function showDelete(productID) {
    document.getElementById("productIdDelete").value = productID;
//    console.log(document.getElementById("productID").value);
    const formIncludeDelete = document.querySelector('.form__include-delete');
    if (formIncludeDelete.classList.contains("active")) {
        formIncludeDelete.classList.remove('active')
    } else {
        formIncludeDelete.classList.add('active')
    }
}

    function showEdit(productID, name, description, quantity, price, size) {
    document.getElementById("productIdUpdate").value = productID;
        console.log(document.getElementById("productIdUpdate").value);
        document.getElementById("name").value = name;
        console.log(document.getElementById("name").value);
        document.getElementById("description").value = description;
        console.log(document.getElementById("description").value);

        document.getElementById("quantity").value = quantity;
        console.log(document.getElementById("quantity").value);

        document.getElementById("price").value = price;
        console.log(document.getElementById("price").value);

        document.getElementById("size").value = size;
        console.log(document.getElementById("size").value);

    //    document.getElementById("uploaded-image1").value = imagedata1;
    //    document.getElementById("uploaded-image2").value = imagedata2;

        const formIncludeUpdate = document.querySelector('.form__include-update');
        if (formIncludeUpdate.classList.contains("active")) {
            formIncludeUpdate.classList.remove('active')
        } else {
            formIncludeUpdate.classList.add('active')
        }

    }




function showCreateProduct() {
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
console.log(selectorRules);
    //Validate 
    function validate(inputElement, rule) {
        // var errorMessage = rule.test(inputElement.value)
        var errorMessage;
        console.log("Error message: ", errorMessage);
        var errorElement = inputElement.parentElement.querySelector(options.errorSelector)
        console.log("ErrorElement : ", errorElement);

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
        var errorMessage = rule.test(inputElement.value);
        var errorElement = inputElement.parentElement.querySelector('.form__message')


        errorElement.innerText = ''
        errorElement.classList.remove('invalid')

    }


    // Lấy element của form 
    var formElement = document.querySelector(options.form);
                    console.log("form Submit: " , formElement)

    if (formElement) {
        // Khi submit form ko bị chuyển trang
        formElement.onsubmit = function (e) { 
            e.preventDefault();

            var isFormValid = true
            // lặp qua từng rules và validate
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector);
                console.log("Inputelement Submit: " , inputElement)
                var isValid = validate(inputElement, rule);
                if (!isValid) {
                    isFormValid= false;
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
                }else{
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
            return value.trim() ? undefined : message || "Vui lòng nhập thông tin!"
        }
    }
}

Validator.isNumber = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /[0-9]+$/;
            return regex.test(value) ? undefined : message || "Vui lòng nhập chữ số nhé!!"
        }
    }
}

Validator.isPositive = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return value < 0 ? "Không được nhập số âm!" || message : undefined;
        }
    }
}




































function Validator2(options) {

    var selectorRules = {};

    //Validate 
    function validate(inputElement, rule) {
        // var errorMessage = rule.test(inputElement.value)
        var errorMessage;
        var errorElement = inputElement.parentElement.querySelector(options.errorSelector);

        // Lấy ra các rule của chính selector
        var rules = selectorRules[rule.selector];
        //Lặp qua từng rule và kiểm tra , nếu có lỗi thì dừng việc kiểm tra
        for (var i = 0; i < rules.length; ++i) {
            errorMessage = rules[i](inputElement.value);
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
            return value.trim() ? undefined : message || "Vui lòng nhập thông tin!"
        }
    }
}


Validator2.isNumber = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /[0-9]+$/;
            return regex.test(value) ? undefined : message || "Vui lòng nhập chữ số nhé!!"
        }
    }
}


Validator2.isPositive = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^(?!(?:0|0\.0|0\.00)$)[+]?\d+(\.\d|\.\d[0-9])?$/;
            return regex.test(value) ? undefined : message || "Vui lòng nhập số dương nhé!!"
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

Validator2.isEmail = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

            return regex.test(value) ? undefined : message || "Vui lòng nhập Email"
        }
    }
}

Validator2.minLength = function (selector, min, message) {
    return {
        selector: selector,
        test: function (value) {

            return value.length >= min ? undefined : message || `Vui lòng nhập tối thiểu ${min} kí tự`
        }
    }
}

Validator2.isComfirmed = function (selector, getConfirmValue, message) {
    return {
        selector: selector,
        test: function (value) {
            return value === getConfirmValue() ? undefined : message || "Giá trị nhập vào không chính xác"
        }
    }
}