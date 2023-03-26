function showDelete(brandID) {
    console.log(123);
    document.getElementById("brandIdDelete").value = brandID;
    console.log(document.getElementById("brandIdDelete").value);
    const formIncludeDelete = document.querySelector('.form__include-delete');
    if (formIncludeDelete.classList.contains("active")) {
        formIncludeDelete.classList.remove('active')
    } else {
        formIncludeDelete.classList.add('active')
    }

}

function showEdit(brandID, name, description, status) {
    document.getElementById("brandIdUpdate").value = brandID;
    console.log( document.getElementById("brandIdUpdate").value)
    document.getElementById("name").value = name;
    document.getElementById("description").value = description;
        document.getElementById("status").value = status;
    const formIncludeUpdate = document.querySelector('.form__include-update');
    if (formIncludeUpdate.classList.contains("active")) {
        formIncludeUpdate.classList.remove('active')
    } else {
        formIncludeUpdate.classList.add('active')
    }

}

function showCreateBrand() {
    const formIncludeCreate = document.querySelector('.form__create');
    if (formIncludeCreate.classList.contains("active")) {
        formIncludeCreate.classList.remove('active')
    } else {
        formIncludeCreate.classList.add('active')
    }

}






// Validation 
function Validator(options) {

    var selectorRules = {};

    //Validate 
    function validate(inputElement, rule) {
        // var errorMessage = rule.test(inputElement.value)
        var errorMessage
        var errorElement = inputElement.parentElement.querySelector(options.errorSelector)

        // Lấy ra các rule của chính selector
        var rules = selectorRules[rule.selector];
        //Lặp qua từng rule và kiểm tra , nếu có lỗi thì dừng việc kiểm tra
        for (var i = 0; i < rules.length; ++i) {
            errorMessage = rules[i](inputElement.value)
            if (errorMessage) {
                break;
            }
        }

        if (errorMessage) {
            errorElement.innerText = errorMessage
            errorElement.classList.add('invalid')
        } else {
            errorElement.innerText = ''
            errorElement.classList.remove('invalid')

        }
        return !errorMessage;
    }

    function validateInputChange(inputElement, rule) {
        var errorMessage = rule.test(inputElement.value)
        var errorElement = inputElement.parentElement.querySelector('.form__message')


        errorElement.innerText = ''
        errorElement.classList.remove('invalid')

    }


    // Lấy element của form 
    var formElement = document.querySelector(options.form);
    if (formElement) {
        // Khi submit form ko bị chuyển trang
        formElement.onsubmit = function (e) {
            e.preventDefault();

            var isFormValid = true
            // lặp qua từng rules và validate
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector);
                var isValid = validate(inputElement, rule);
                if (!isValid) {
                    isFormValid = false;
                }
            });


            if (isFormValid) {
                // Trường hợp submit với js
                if (typeof options.onSubmit === 'function') {
                    //
                    var enableInputs = formElement.querySelectorAll('[name]');
                    var formValues = Array.from(enableInputs).reduce(function (values, input) {
                        return (values[input.name] = input.value) && values;
                    }, {});

                    options.onSubmit(formValues)
                } else {
                    // trường hợp submit với yêu cầu mặc định
                    formElement.submit();
                }
            }
        }

        //Xử lí lặp qua mỗi rule xử lí blur ra ngoài, input, .....
        options.rules.forEach(function (rule) {

            // Lưu lại các rules cho mỗi input vào
            if (Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test)
            } else {
                selectorRules[rule.selector] = [rule.test]
            }

            var inputElement = formElement.querySelector(rule.selector);

            if (inputElement) {
                // Xử lí blur ra khỏi ô input
                inputElement.onblur = function () {
                    validate(inputElement, rule);

                }

                inputElement.oninput = function () {
                    validateInputChange(inputElement, rule)
                }
            }
        });

        // console.log(selectorRules)
    }

}


// Khi có lỗi trả ra message lỗi
// Khi hợp lệ ko trả ra cái gì (undifined)
Validator.isRequired = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : message || "Vui lòng nhập thông tin"
        }
    }
}

























// Add a new product validation

function Validator2(options) {

    var selectorRules = {};

    //Validate 
    function validate(inputElement, rule) {
        // var errorMessage = rule.test(inputElement.value)
        var errorMessage
        var errorElement = inputElement.parentElement.querySelector(options.errorSelector)

        // Lấy ra các rule của chính selector
        var rules = selectorRules[rule.selector];
        //Lặp qua từng rule và kiểm tra , nếu có lỗi thì dừng việc kiểm tra
        for (var i = 0; i < rules.length; ++i) {
            errorMessage = rules[i](inputElement.value)
            if (errorMessage) {
                break;
            }
        }

        if (errorMessage) {
            errorElement.innerText = errorMessage
            errorElement.classList.add('invalid')
        } else {
            errorElement.innerText = ''
            errorElement.classList.remove('invalid')

        }
        return !errorMessage;
    }

    function validateInputChange(inputElement, rule) {
        var errorMessage = rule.test(inputElement.value)
        var errorElement = inputElement.parentElement.querySelector('.form__message')


        errorElement.innerText = ''
        errorElement.classList.remove('invalid')

    }


    // Lấy element của form 
    var formElement = document.querySelector(options.form);
    if (formElement) {
        // Khi submit form ko bị chuyển trang
        formElement.onsubmit = function (e) {
            e.preventDefault();

            var isFormValid = true
            // lặp qua từng rules và validate
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector);
                var isValid = validate(inputElement, rule);
                if (!isValid) {
                    isFormValid = false;
                }
            });


            if (isFormValid) {
                // Trường hợp submit với js
                if (typeof options.onSubmit === 'function') {
                    //
                    var enableInputs = formElement.querySelectorAll('[name]');
                    var formValues = Array.from(enableInputs).reduce(function (values, input) {
                        return (values[input.name] = input.value) && values;
                    }, {});

                    options.onSubmit(formValues)
                } else {
                    // trường hợp submit với yêu cầu mặc định
                    formElement.submit();
                }
            }
        }

        //Xử lí lặp qua mỗi rule xử lí blur ra ngoài, input, .....
        options.rules.forEach(function (rule) {

            // Lưu lại các rules cho mỗi input vào
            if (Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test)
            } else {
                selectorRules[rule.selector] = [rule.test]
            }

            var inputElement = formElement.querySelector(rule.selector);

            if (inputElement) {
                // Xử lí blur ra khỏi ô input
                inputElement.onblur = function () {
                    validate(inputElement, rule);

                }

                inputElement.oninput = function () {
                    validateInputChange(inputElement, rule)
                }
            }
        });

        // console.log(selectorRules)
    }

}
Validator2.isRequired = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : message || "Vui lòng nhập thông tin"
        }
    }
}

