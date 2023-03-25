<%-- 
    Document   : shipping
    Created on : Feb 26, 2023, 2:47:36 PM
    Author     : Duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Payment-2</title>
        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
            />

        <link rel="stylesheet" href="style/reset.css" />
        <link rel="stylesheet" href="style/payment-2.css" />
    </head>
    <body>
        <div class="wrapper">
            <!-- HEADER -->
            <header class="header">

                <div class="nav-top">
                    <div class="container">
                        <div class="shipping">
                            <p class="shipping-text">Free shipping with recept from 200$</p>
                        </div>
                    </div>
                </div>
                <img src="images/Nav-line.png" alt="" class="nav-line" />
                <!-- NAV DESKTOP - TABLET -->
                <div class="nav-bot">
                    <div class="container">
                        <a href="mainPage" class="menu-logo"> LOGO </a>
                        <ul class="menu">
                            <li class="menu-item">
                                <a href="#!" class="menu-link menu-link-category">Categories</a>
                                <ul class="menu-link-category-tab">
                                    <div class="container">
                                        <li class="menu-link-category-tab-title">
                                            <a href="SearchByFilterServlet?txtProductCateID=1" class="menu-link menu-link-bracelet"
                                               >BRACELET</a
                                            >
                                            <ul class="menu-link-category-tab-list">
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-bracelet">
                                                        1
                                                    </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-bracelet">
                                                        2
                                                    </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-bracelet">
                                                        3
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="menu-link-category-tab-title">
                                            <a href="SearchByFilterServlet?txtProductCateID=2!" class="menu-link menu-link-ring"> RING </a>
                                            <ul class="menu-link-category-tab-list">
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-ring"> 1 </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-ring"> 2 </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-ring"> 3 </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="menu-link-category-tab-title">
                                            <a href="SearchByFilterServlet?txtProductCateID=3" class="menu-link menu-link-necklace">
                                                NECKLACE
                                            </a>
                                            <ul class="menu-link-category-tab-list">
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-necklace">
                                                        1
                                                    </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-necklace">
                                                        2
                                                    </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-necklace">
                                                        3
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="menu-link-category-tab-title">
                                            <a href="SearchByFilterServlet?txtProductCateID=4" class="menu-link menu-link-earring">
                                                EARRINGS
                                            </a>
                                            <ul class="menu-link-category-tab-list">
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-earring">
                                                        1
                                                    </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-earring">
                                                        2
                                                    </a>
                                                </li>
                                                <li class="menu-link-category-tab-list-item">
                                                    <a href="#!" class="menu-link menu-link-earring">
                                                        3
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                    </div>
                                </ul>
                            </li>
                            <li class="menu-item">
                                <a href="#!" class="menu-link">About</a>
                            </li>
                            <li class="menu-item">
                                <a href="#!" class="menu-link">Shop</a>
                            </li>
                            <li class="menu-item">
                                <a href="#!" class="menu-link">Contact</a>
                            </li>
                        </ul>
                        <div class="menu-icon">
                            <!-- SEARCH -->
                            <div class="menu-icon-tab">
                                <button class="menu-icon-tab-search" href="#!">
                                    <img
                                        class="menu-icon-img"
                                        srcset="images/search-normal.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-icon-tab-search-content">
                                    <div class="container">
                                        <div class="menu-icon-tab-search-content-title">
                                            <p class="menu-icon-tab-search-content-title-desc">
                                                SEARCH
                                            </p>
                                            <img srcset="images/Footer-line.png 2x" alt="" />
                                        </div>
                                        <div class="menu-icon-tab-search-form">
                                            <form action="searchTextController">
                                                <input
                                                    type="text"
                                                    id="search-button"
                                                    class="menu-icon-tab-search-input"
                                                    placeholder="Search Product..."
                                                    name="txtSearch" value="${param.txtSearch}"
                                                    />
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- PROFILE -->
                            <div class="menu-icon-tab">
                                <button class="menu-icon-tab-profile" href="#!">
                                    <img
                                        class="menu-icon-img"
                                        srcset="images/profile-circle.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-icon-tab-profile-content">
                                    <div class="container">
                                        <c:if test="${not empty sessionScope.USER}">
                                            <div class="menu-icon-tab-profile-content-title">
                                                <p class="menu-icon-tab-profile-content-title-desc">
                                                    ACCOUNT INFORMATION
                                                </p>
                                                <img srcset="images/Footer-line.png 2x" alt="" />
                                            </div>
                                            <div class="menu-icon-tab-profile-form">
                                                <p class="menu-icon-tab-profile-form-name">${sessionScope.USER.name}</p>
                                                <a href="userInforPage" class="menu-icon-tab-profile-form-link"
                                                   >My account</a
                                                >
                                                <!--                                            <a href="#!" class="menu-icon-tab-profile-form-link"
                                                                                               >Address List</a
                                                                                            >-->
                                                <a href="logoutController" class="menu-icon-tab-profile-form-link"
                                                   >Log out</a
                                                >
                                            </div>
                                        </c:if>
                                        <c:if test="${empty sessionScope.USER}">
                                            <p style="font-size: 15px; margin: 5px 0">You are not already logged <span style="color: red">PLEASE LOGIN FIRST!!</span></p><br/>
                                            <%--<c:set var="URL" value="userCart.jsp" scope="session"/>--%>
                                            <form action="loginPage" method="GET">
                                                <button class="menu-icon-tab-cart-content-function-method-btn">
                                                    <a style="font-size: 15px; text-decoration: none; font-weight: bold; color: inherit" href="loginPage">LOGIN</a>
                                                </button>
                                            </form>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <!-- CART -->
                            <div class="menu-icon-tab">
                                <button class="menu-icon-tab-cart" href="#!">
                                    <img
                                        class="menu-icon-img"
                                        srcset="images/shopping-cart.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-icon-tab-cart-content">
                                    <div class="container">
                                        <div class="menu-icon-tab-cart-content-title">
                                            <div class="menu-icon-tab-cart-content-title-container">
                                                <p class="menu-icon-tab-cart-content-title-desc">
                                                    Cart
                                                </p>
                                                <img
                                                    srcset="images/Footer-line.png 2x"
                                                    alt=""
                                                    class="menu-icon-tab-cart-space"
                                                    />
                                            </div>
                                        </div>
                                        <div class="menu-icon-tab-cart-content-show">
                                            <div class="menu-icon-tab-cart-content-show-icon">
                                                <img
                                                    srcset="images/shopping-icon-tab.png 2x"
                                                    alt=""
                                                    />
                                            </div>
                                            <div class="menu-icon-tab-cart-content-show-txt">
                                                <c:set var="cartSize" value="${sessionScope.CART.items.size()}"/>
                                                <c:set var="totalQuantity" value="${0}" />
                                                <c:forEach var="quantity" items="${sessionScope.CART.items.values()}">
                                                    <c:set var="totalQuantity" value="${totalQuantity + quantity}" />
                                                </c:forEach>

                                                <c:if test="${empty sessionScope.CART.items.size()}">
                                                    <c:set var="totalQuantity" value="${0}"/>
                                                </c:if>
                                                <p class="menu-icon-tab-cart-content-show-txt-desc">
                                                    <c:if test="${cartSize eq 0}">
                                                        There are no currently products.
                                                    </c:if>
                                                    <c:if test="${cartSize ne 0}">
                                                        There are <span id="cart-size-header" style="font-weight: bold">${totalQuantity}</span> products
                                                    </c:if>
                                                </p>
                                            </div>
                                        </div>
                                        <img srcset="images/Footer-line.png 2x" alt="" />
                                        <c:set var="listCart" value="${sessionScope.CART}"/>
                                        <c:set var="totalPrice" value="${0}"/>

                                        <c:forEach var="item" items="${sessionScope.CART.items}">
                                            <c:forEach var="detail" items="${sessionScope.CART.itemDetail}">
                                                <c:if test="${item.key eq detail.key}">
                                                    <c:set var="totalPrice" value="${totalPrice + (item.value * detail.value.price)}"/>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                        <%--<fmt:parseNumber var="totalPrice" type="number" value="${totalPrice}"/>--%>
                                        <div class="menu-icon-tab-cart-content-function">
                                            <div class="menu-icon-tab-cart-content-function-total">
                                                <p
                                                    class="menu-icon-tab-cart-content-function-total-txt"
                                                    >
                                                    TOTAL AMOUNT
                                                </p>
                                                <p
                                                    class="menu-icon-tab-cart-content-function-total-price"
                                                    >

                                                    <fmt:formatNumber var="price" value="${totalPrice}" pattern="#,##0" groupingUsed="true"/>
                                                    ${price}đ
                                                </p>
                                            </div>
                                            <div class="menu-icon-tab-cart-content-function-method">
                                                <form action="addToCartPage" method="POST">
                                                    <button
                                                        class="menu-icon-tab-cart-content-function-method-btn"
                                                        >
                                                        VIEW CART
                                                    </button>
                                                </form>
                                                <button
                                                    class="pay-button menu-icon-tab-cart-content-function-method-btn"
                                                    >
                                                    PAY
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- NAV MOBILE -->
                <div class="nav-bot-responsive">
                    <div class="container">
                        <div class="menu-responsive-icon">
                            <!-- <img
                                     class="menu-responsive-icon-img"
                                     srcset="./../../images/shopping-cart.png 2x"
                                     alt=""
                                   /> -->
                            <div class="menu-responsive-icon-tab">
                                <button class="menu-responsive-icon-tab-cart" href="#!">
                                    <img
                                        class="menu-responsive-icon-img menu-responsive-icon-img-cart"
                                        srcset="images/shopping-cart.png 2x"
                                        alt=""
                                        />
                                </button>
                                <div class="menu-responsive-icon-tab-cart-content">
                                    <div class="container">
                                        <div class="menu-responsive-icon-tab-cart-content-title">
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-title-container"
                                                >
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-title-desc"
                                                    >
                                                    Cart
                                                </p>
                                                <img
                                                    srcset="images/Footer-line.png 2x"
                                                    alt=""
                                                    class="menu-responsive-icon-tab-cart-space"
                                                    />
                                            </div>
                                        </div>
                                        <div class="menu-responsive-icon-tab-cart-content-show">
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-show-icon"
                                                >
                                                <img
                                                    srcset="images/shopping-icon-tab.png 2x"
                                                    alt=""
                                                    />
                                            </div>
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-show-txt"
                                                >
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-show-txt-desc"
                                                    >
                                                    There are currently no products
                                                </p>
                                            </div>
                                        </div>
                                        <img srcset="images/Footer-line.png 2x" alt="" />
                                        <div class="menu-responsive-icon-tab-cart-content-function">
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-function-total"
                                                >
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-function-total-txt"
                                                    >
                                                    TOTAL AMOUNT
                                                </p>
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-function-total-price"
                                                    >
                                                    0₫
                                                </p>
                                            </div>
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-function-method"
                                                >
                                                <form action="addToCartPage" method="POST">
                                                    <button
                                                        class="menu-responsive-icon-tab-cart-content-function-method-btn"
                                                        >
                                                        VIEW CART
                                                    </button>
                                                </form>
                                                <button
                                                    class="pay-button menu-responsive-icon-tab-cart-content-function-method-btn"
                                                    >
                                                    PAY
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="#!" class="menu-responsive-logo"> LOGO </a>
                        <div class="menu-responsive-icon">
                            <img
                                class="menu-responsive-icon-img menu-responsive-icon-img-bar"
                                srcset="images/textalign-justifycenter.png 2x"
                                alt=""
                                />
                        </div>
                    </div>
                </div>
                <!--  -->
                <img src="images/Nav-line.png" alt="" class="nav-line-bot" />
            </header>
            <section class="shipping-info">
                <c:set var="customerInfomation" value="${sessionScope.USER}"/>

                <div class="container">
                    <div class="shipping-info-left">
                        <div class="container">
                            <div class="shipping-info-left-breadcrumb">
                                <div class="container">
                                    <ul class="shipping-info-left-breadcrumb-menu">
                                        <li>Cart</li>
                                        <li>Shipping information</li>
                                        <li>Payment methods</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="shipping-info-left-avatar">
                                <div class="container">
                                    <div class="shipping-info-left-avatar-icon">
                                        <i class="fa-solid fa-user"></i>
                                    </div>
                                    <div class="shipping-info-left-avatar-content">
                                        <p class="shipping-info-left-avatar-content-name">
                                            ${customerInfomation.name}
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <c:set var = "errors" value="${requestScope.SIGNUPFORSHIPPING_ERROR}"/>
                            <form action="shippingController" method="POST">
                                <c:if test="${not empty sessionScope.USER}">                                                   
                                    <input type="hidden" name="txtCustomerID" value="${customerInfomation.customerID}" />


                                    <div class="shipping-info-left-form-delivery">
                                        <div class="container">                                                                                                                                                  
                                            <div class="shipping-info-left-form-delivery-home">
                                                <label class="radio-label">
                                                    <div class="radio-input">
                                                        <input
                                                            value="${0}"
                                                            type="radio"
                                                            id="location"
                                                            name="defaultOrNewShippingInfor"
                                                            class="input-radio"
                                                            />
                                                    </div>
                                                    <span class="radio-label-primary">Default shipping information</span>
                                                </label>
                                            </div>

                                            <div class="shipping-info-left-form-delivery-address-option">
                                                <div class="container">
                                                    <label class="field-label" for="stored-address">Choose your Information here...</label>
                                                    <select class="field-input" id="stored-addresses" name="stored-infoCus-by-orDetID">
                                                        <option class="field-input-item" value="">Choose your Information here</option>
                                                        <c:forEach items="${USER_SHIPPINGINFO}" var="customer">
                                                            <option class="field-input-item" value="${customer.ordersID}" >
                                                                ${customer.cusName}, ${customer.cusPhone}, ${customer.cusAddress}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <c:if test="${not empty errors.cusInfoLengthError}">
                                                    <font color="red">${errors.cusInfoLengthError}</font><br/>
                                                </c:if>
                                            </div>
                                            <c:if test="${not empty errors.defaultOrNewShippingInforLengthError}">
                                                <font color="red">${errors.defaultOrNewShippingInforLengthError}</font><br/>
                                            </c:if>
                                            <div class="shipping-info-left-form-delivery-store">
                                                <div class="shipping-info-left-form-delivery-home-new">
                                                    <label class="radio-label">
                                                        <div class="radio-input">
                                                            <input
                                                                value="${1}"
                                                                type="radio"
                                                                id="location"
                                                                name="defaultOrNewShippingInfor"
                                                                class="input-radio"
                                                                />
                                                        </div>
                                                        <span class="radio-label-primary"
                                                              >Add new shipping information</span
                                                        >
                                                    </label>
                                                </div>     
                                                <div class="shipping-info-left-form-delivery-store-info"> 
                                                    <div class="shipping-info-left-form-name">
                                                        <div class="container">
                                                            <label class="field-label" for="stored-name"
                                                                   >Enter First Name...</label
                                                            >
                                                            <input
                                                                type="text"
                                                                name="txtFirstName"
                                                                value="${param.txtFirstName}"
                                                                class="field-input"
                                                                id="stored-name"
                                                                placeholder="First Name"
                                                                />
                                                        </div>
                                                        <c:if test="${not empty errors.firstNameLengthError}">
                                                            <font color="red">
                                                            ${errors.firstNameLengthError}
                                                            </font><br/>
                                                        </c:if>

                                                    </div>
                                                    <div class="shipping-info-left-form-name-last">
                                                        <div class="container">
                                                            <label class="field-label" for="stored-name"
                                                                   >Enter Last Name...</label
                                                            >                                           
                                                            <input
                                                                type="text"
                                                                name="txtLastName"
                                                                value="${param.txtLastName}"
                                                                class="field-input"
                                                                id="stored-name"
                                                                placeholder="Last Name"
                                                                />
                                                            <!-- Ở ĐÂY CŨNG CÓ THỂ TRUYỀN ID NAME VÀ VALUE ĐÊ TỰ ĐIỀN -->
                                                        </div>
                                                        <c:if test="${not empty errors.lastNameLengthError}">
                                                            <font color="red">
                                                            ${errors.lastNameLengthError}
                                                            </font><br/>
                                                        </c:if>
                                                    </div>
                                                    <div class="shipping-info-left-form-phone">                                                                                           
                                                        <div class="container">
                                                            <label class="field-label" for="stored-phone"
                                                                   >Enter phone number...</label
                                                            >
                                                            <input
                                                                type="tel"
                                                                name="txtPhone"
                                                                value="${param.txtPhone}"
                                                                class="field-input"
                                                                id="stored-phone"
                                                                placeholder="Enter phone number"
                                                                />
                                                            <!-- Ở ĐÂY CŨNG CÓ THỂ TRUYỀN ID NAME VÀ VALUE ĐÊ TỰ ĐIỀN -->
                                                        </div>
                                                        <c:if test="${not empty errors.phoneLengthError}">
                                                            <font color="red">
                                                            ${errors.phoneLengthError}
                                                            </font><br/>
                                                        </c:if>
                                                    </div>
                                                    <div class="shipping-info-left-form-delivery-address">
                                                        <div class="container">
                                                            <label class="field-label" for="stored-address"
                                                                   >Enter your address...</label
                                                            >
                                                            <input
                                                                name="txtAddress"
                                                                type="text"
                                                                class="field-input"
                                                                id="stored-phone"
                                                                placeholder="Enter Address"
                                                                />                                                   
                                                            <!-- Ở ĐÂY CŨNG CÓ THỂ TRUYỀN ID NAME VÀ VALUE ĐÊ TỰ ĐIỀN -->
                                                        </div>
                                                        <c:if test="${not empty errors.addressLengthError}">
                                                            <font color="red">
                                                            ${errors.addressLengthError}
                                                            </font><br/>
                                                        </c:if>
                                                    </div>

                                                    <div
                                                        class="shipping-info-left-form-delivery-address-select"
                                                        >
                                                        <!-- CITY -->
                                                        <div class="shipping-info-left-form-city">
                                                            <div class="container">
                                                                <label class="field-label" for="stored-city"
                                                                       >Province / City</label
                                                                >
                                                                <select class="field-input" id="stored-city">
                                                                    <option
                                                                        class="field-input-item"
                                                                        data-name=""
                                                                        value=""
                                                                        >
                                                                        Choose Province / city
                                                                        <!-- Ở ĐÂY OPTION MÌNH CÓ THỂ TRUYỀN ĐƯỢC data-properties={"nội dung"} và value ={} -->
                                                                    </option>

                                                                </select>
                                                            </div>
                                                            <input type="hidden" id="txtCityDataName" name="txtCityDataName" value="">
                                                        </div>
                                                        <!-- DISTRICT -->
                                                        <div class="shipping-info-left-form-district">
                                                            <div class="container">
                                                                <label class="field-label" for="stored-district"
                                                                       >District</label
                                                                >
                                                                <select class="field-input" id="stored-district">
                                                                    <option
                                                                        class="field-input-item"
                                                                        data-name=""
                                                                        value=""
                                                                        >
                                                                        Choose District
                                                                        <!-- Ở ĐÂY OPTION MÌNH CÓ THỂ TRUYỀN ĐƯỢC data-properties={"nội dung"} và value ={} -->
                                                                    </option>
                                                                </select>
                                                            </div>
                                                            <input type="hidden" id="txtDistrictDataName" name="txtDistrictDataName" value="">
                                                        </div>
                                                        <!-- WARD -->
                                                        <div class="shipping-info-left-form-ward">
                                                            <div class="container">
                                                                <label class="field-label" for="stored-ward"
                                                                       >Wards</label
                                                                >
                                                                <select class="field-input" id="stored-ward">
                                                                    <option
                                                                        class="field-input-item"
                                                                        data-name=""
                                                                        value=""
                                                                        >
                                                                        Choose Wards
                                                                        <!-- Ở ĐÂY OPTION MÌNH CÓ THỂ TRUYỀN ĐƯỢC data-properties={"nội dung"} và value ={} -->
                                                                    </option>
                                                                </select>
                                                            </div>
                                                            <input type="hidden" id="txtWardDataName" name="txtWardDataName" value="">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="shipping-info-left-form-delivery">
                                        <div class="container">                                                                                                                                                  
                                            <div class="shipping-info-left-form-delivery-home">
                                                <label class="radio-label">
                                                    <div class="radio-input">
                                                        <input
                                                            value="${1}"
                                                            type="radio"
                                                            id="location"
                                                            name="location"
                                                            class="input-radio"
                                                            />
                                                    </div>
                                                    <span class="radio-label-primary">Cash On Delivery (COD)</span>
                                                </label>
                                            </div>
                                            
                                        </div>
                                        <c:if test="${not empty errors.shippingIDLengthError}">
                                            <font color="red">
                                            ${errors.shippingIDLengthError}
                                            </font><br/>
                                        </c:if>
                                    </div>
                                </c:if>
                                <c:set var="uri" value="${pageContext.request.requestURI}" scope="session"/>
                                <c:if test="${empty sessionScope.USER}">

                                    <p style="font-size: 15px; margin: 5px 0">YOU ARE NOT ALREADY LOGGED, PLEASE LOGIN FIRST!! <a href="loginPage">Login here </a></p>
                                    <c:set var="shippingPage" value="${pageContext.request.requestURI}" scope="session" />


                                    <div class="shipping-info-left-form">

                                        <div class="shipping-info-left-form-name">
                                            <div class="container">
                                                <label class="field-label" for="stored-name"
                                                       >Enter First Name...</label
                                                >
                                                <input
                                                    type="text"
                                                    name="txtFirstName"
                                                    value="${param.txtFirstName}"
                                                    class="field-input"
                                                    id="stored-name"
                                                    placeholder="First Name"
                                                    />
                                            </div>
                                            <c:if test="${not empty errors.firstNameLengthError}">
                                                <font color="red">
                                                ${errors.firstNameLengthError}
                                                </font><br/>
                                            </c:if>

                                        </div>
                                        <div class="shipping-info-left-form-name-last">
                                            <div class="container">
                                                <label class="field-label" for="stored-name"
                                                       >Enter Last Name...</label
                                                >                                           
                                                <input
                                                    type="text"
                                                    name="txtLastName"
                                                    value="${param.txtLastName}"
                                                    class="field-input"
                                                    id="stored-name"
                                                    placeholder="Last Name"
                                                    />
                                                <!-- Ở ĐÂY CŨNG CÓ THỂ TRUYỀN ID NAME VÀ VALUE ĐÊ TỰ ĐIỀN -->
                                            </div>
                                            <c:if test="${not empty errors.lastNameLengthError}">
                                                <font color="red">
                                                ${errors.lastNameLengthError}
                                                </font><br/>
                                            </c:if>
                                        </div>
                                        <div class="shipping-info-left-form-phone">                                                                                           
                                            <div class="container">
                                                <label class="field-label" for="stored-phone"
                                                       >Enter phone number...</label
                                                >
                                                <input
                                                    type="tel"
                                                    name="txtPhone"
                                                    value="${param.txtPhone}"
                                                    class="field-input"
                                                    id="stored-phone"
                                                    placeholder="Enter phone number"
                                                    />
                                                <!-- Ở ĐÂY CŨNG CÓ THỂ TRUYỀN ID NAME VÀ VALUE ĐÊ TỰ ĐIỀN -->
                                            </div>
                                            <c:if test="${not empty errors.phoneLengthError}">
                                                <font color="red">
                                                ${errors.phoneLengthError}
                                                </font><br/>
                                            </c:if>
                                        </div>
                                        <div class="shipping-info-left-form-email">
                                            <div class="container">
                                                <label class="field-label" for="stored-email"
                                                       >Enter Email Address...</label
                                                >
                                                <input
                                                    type="tel"
                                                    name="txtEmail"
                                                    value="${param.txtEmail}"
                                                    class="field-input"
                                                    id="stored-email"
                                                    placeholder="Enter email"
                                                    />
                                                <!-- Ở ĐÂY CŨNG CÓ THỂ TRUYỀN ID NAME VÀ VALUE ĐÊ TỰ ĐIỀN -->
                                            </div>
                                            <c:if test="${not empty errors.emailLengthError}">
                                                <font color="red">
                                                ${errors.emailLengthError}
                                                </font><br/>
                                            </c:if>
                                            <c:if test="${not empty errors.emailIsExisted}">
                                                <font color="red">
                                                ${errors.emailIsExisted}
                                                </font><br/>
                                            </c:if>
                                        </div>
                                        <div class="shipping-info-left-form-delivery">
                                            <div class="container">                                                                                                                                                  
                                                <div class="shipping-info-left-form-delivery-home">
                                                    <label class="radio-label">
                                                        <div class="radio-input">
                                                            <input
                                                                value="${1}"
                                                                type="radio"
                                                                id="location"
                                                                name="location"
                                                                class="input-radio"
                                                                />
                                                        </div>
                                                        <span class="radio-label-primary">Cash On Delivery (COD)</span>
                                                    </label>
                                                </div>
                                                <c:if test="${not empty errors.shippingIDLengthError}">
                                                    <font color="red">
                                                    ${errors.shippingIDLengthError}
                                                    </font><br/>
                                                </c:if>

                                                <div class="shipping-info-left-form-delivery-address">
                                                    <div class="container">
                                                        <label class="field-label" for="stored-address"
                                                               >Enter your address...</label
                                                        >
                                                        <input
                                                            name="txtAddress"
                                                            type="text"
                                                            class="field-input"
                                                            id="stored-phone"
                                                            placeholder="Enter Address"
                                                            />
                                                        <!-- Ở ĐÂY CŨNG CÓ THỂ TRUYỀN ID NAME VÀ VALUE ĐÊ TỰ ĐIỀN -->
                                                    </div>
                                                    <c:if test="${not empty errors.addressLengthError}">
                                                        <font color="red">
                                                        ${errors.addressLengthError}
                                                        </font><br/>
                                                    </c:if>
                                                </div>
                                                <div class="shipping-info-left-form-delivery-address-select">
                                                    <!-- CITY -->
                                                    <div class="shipping-info-left-form-city">
                                                        <div class="container">
                                                            <label class="field-label" for="stored-city"
                                                                   >Province / City</label
                                                            >
                                                            <select class="field-input" id="stored-city" name="txtCity">
                                                                <option
                                                                    class="field-input-item"
                                                                    data-name=""
                                                                    value=""
                                                                    >
                                                                    Choose Province / city
                                                                    <!-- Ở ĐÂY OPTION MÌNH CÓ THỂ TRUYỀN ĐƯỢC data-properties={"nội dung"} và value ={} -->
                                                                </option>
                                                            </select>
                                                        </div>
                                                        <input type="hidden" id="txtCityDataName" name="txtCityDataName" value="">
                                                    </div>
                                                    <!-- DISTRICT -->
                                                    <div class="shipping-info-left-form-district">
                                                        <div class="container">
                                                            <label class="field-label" for="stored-district"
                                                                   >District</label
                                                            >
                                                            <select class="field-input" id="stored-district" name="txtDistrict">
                                                                <option
                                                                    class="field-input-item"
                                                                    data-name=""
                                                                    value=""
                                                                    >
                                                                    Choose District
                                                                    <!-- Ở ĐÂY OPTION MÌNH CÓ THỂ TRUYỀN ĐƯỢC data-properties={"nội dung"} và value ={} -->
                                                                </option>
                                                            </select>
                                                        </div>
                                                        <input type="hidden" id="txtDistrictDataName" name="txtDistrictDataName" value="">
                                                    </div>
                                                    <!-- WARD -->
                                                    <div class="shipping-info-left-form-ward">
                                                        <div class="container">
                                                            <label class="field-label" for="stored-ward"
                                                                   >Ward</label
                                                            >
                                                            <select class="field-input" id="stored-ward" name="txtWard">
                                                                <option
                                                                    class="field-input-item"
                                                                    data-name=""
                                                                    value=""
                                                                    >
                                                                    Choose Wards
                                                                    <!-- Ở ĐÂY OPTION MÌNH CÓ THỂ TRUYỀN ĐƯỢC data-properties={"nội dung"} và value ={} -->
                                                                </option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <input type="hidden" id="txtWardDataName" name="txtWardDataName" value="">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <button class="shipping-info-left-btn" type="submit">
                                    Continue to payment method
                                </button>
                            </form>
                        </div>
                    </div>

                    <img
                        srcset="images/Login-line.png 2x"
                        alt=""
                        class="shipping-info-space"
                        />
                    <!-- RIGHT -->
                    <div class="shipping-info-right">
                        <c:set var="cartList" value="${sessionScope.CART.items}" />
                        <c:set var="cartListDetail" value="${sessionScope.CART.itemDetail}" />
                        <c:set var="total" value="0" />
                        <div class="container">
                            <c:if test="${ empty cartList}">
                                <font color="red">
                                your cart is empty
                                </font><br/>
                            </c:if>
                            <c:forEach var="item" items="${cartList}" varStatus="counter">
                                <c:forEach var="detail" items="${cartListDetail}">
                                    <c:if test="${item.key eq detail.key}">
                                        <div class="shipping-info-right-product">
                                            <div class="container">
                                                <div class="shipping-info-right-product-logo">
                                                    <div class="container">
                                                        <div class="shipping-info-right-product-logo-img">
                                                            <img
                                                                src="images/product-demo.png"
                                                                alt=""
                                                                class="shipping-info-right-product-logo-img-pic"
                                                                />
                                                        </div>
                                                        <span class="shipping-info-right-product-logo-quantity">
                                                            ${item.value}
                                                        </span>
                                                    </div>
                                                </div>
                                                <div class="shipping-info-right-product-content">
                                                    <div class="container">
                                                        <div class="shipping-info-right-product-content-name">
                                                            <div class="container">
                                                                <p
                                                                    class="shipping-info-right-product-content-name-title"
                                                                    >
                                                                    ${detail.value.name}
                                                                </p>
                                                                <p
                                                                    class="shipping-info-right-product-content-name-size"
                                                                    >
                                                                    ${detail.value.size}
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="shipping-info-right-product-content-price">                                                            
                                                            <div class="container">
                                                                <p class="shipping-info-right-product-content-price-number">

                                                                    <fmt:formatNumber var="price" value="${detail.value.price * item.value}" pattern="#,##0" groupingUsed="true"/>
                                                                    ${price}₫
                                                                </p>
                                                            </div>
                                                            <c:set var="total" value="${total + detail.value.price * item.value}" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>

                            <div class="shipping-info-right-product-fee">
                                <div class="container">
                                    <div class="shipping-info-right-product-fee-name">
                                        <div class="container">
                                            <p
                                                class="shipping-info-right-product-fee-name-provisional"
                                                >
                                                Provisional
                                            </p>
                                            <!--                                            <p
                                                                                            class="shipping-info-right-product-fee-name-ship"
                                                                                            >
                                                                                            Shipping fee
                                                                                        </p>-->
                                        </div>
                                    </div>
                                    <div class="shipping-info-right-product-fee-price">
                                        <div class="container">
                                            <p class="shipping-info-right-product-fee-price-provisional">
                                                <fmt:formatNumber var="totalDisplay1" value="${total}" pattern="#,##0" groupingUsed="true"/>
                                                ${totalDisplay1}₫
                                            </p>
                                            <!--                                            <p class="shipping-info-right-product-fee-price-ship">
                                            <c:set var="fee-price-ship" value="${10}" />10
                                        </p>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="shipping-info-right-product-total">
                                <div class="container">
                                    <div class="shipping-info-right-product-total-name">
                                        <div class="container">
                                            <p
                                                class="shipping-info-right-product-total-name-title"
                                                >
                                                Total
                                            </p>
                                        </div>
                                    </div>
                                    <div class="shipping-info-right-product-total-price">
                                        <div class="container">
                                            <p class="shipping-info-right-product-total-price-country">
                                                VND
                                            </p>
                                            <p class="shipping-info-right-product-total-price-number">
                                                <fmt:formatNumber var="totalDisplay2" value="${total}" pattern="#,##0" groupingUsed="true"/>
                                                ${totalDisplay2}₫
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- RIGHT -->
                </div>
            </section>

            <!-- FOOTER -->
            <img src="images/Footer-line.png" alt="" />
            <footer class="footer">
                <div class="container">
                    <div class="footer-menu">
                        <div class="footer-menu-connect">
                            <h3 class="footer-menu-connect-title">CONNECT WITH US</h3>
                            <div class="footer-menu-connect-desc">
                                <p class="footer-menu-connect-desc-txt">
                                    PTDK is an accessory brand founded by people who are
                                    passionate about jewelry, love the crafts created by pure
                                    Vietnamese hands, and want to bring the works to the world.
                                </p>
                                <p class="footer-menu-connect-desc-txt">
                                    PTDK Company (Phat-Truong-Dung-Duy-Khoa)
                                </p>
                                <p class="footer-menu-connect-desc-txt">
                                    Email: cubiiwork@gmail.com
                                </p>
                                <p class="footer-menu-connect-desc-txt">Zip code: 70000</p>
                            </div>
                            <div class="footer-menu-connect-icon">
                                <span class="footer-menu-connect-icon-facebook"
                                      ><i class="fa-brands fa-facebook-f"></i
                                    ></span>
                                <span class="footer-menu-connect-icon-instagram"
                                      ><i class="fa-brands fa-instagram"></i
                                    ></span>
                            </div>
                        </div>
                        <div class="footer-menu-cus-service">
                            <h3 class="footer-menu-cus-service-title">CUSTOMER SERVICE</h3>
                            <div class="footer-menu-cus-service-desc">
                                <p class="footer-menu-cus-service-desc-txt">TERMS OF SERVICE</p>
                                <p class="footer-menu-cus-service-desc-txt">REFUND POLICY</p>
                            </div>
                        </div>
                        <div class="footer-menu-about">
                            <h3 class="footer-menu-about-title">ABOUT US</h3>
                            <div class="footer-menu-about-desc">
                                <p class="footer-menu-about-desc-txt">STORY OF PDTK</p>
                            </div>
                        </div>
                        <div class="footer-menu-care">
                            <h3 class="footer-menu-care-title">FOR CUSTOMERS</h3>
                            <div class="footer-menu-care-desc">
                                <p class="footer-menu-care-desc-txt">
                                    INSTRUCTIONS FOR STORAGE OF US PRODUCTS
                                </p>
                                <p class="footer-menu-care-desc-txt">FASHION KNOWLEDGE</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-copyright">
                    <div class="container">
                        <p class="footer-copyright-txt">© 2023 PTDK All Rights Reserved.</p>
                    </div>
                </div>
            </footer>
        </div>
        <script src="js/shipping.js"></script>  
        <script src="js/handleEvent.js"></script>
        <script src="js/header.js"></script>
        <script src="js/handleEvent1.js"></script>
    </body>
</html>
