<%-- 
    Document   : payment
    Created on : Feb 26, 2023, 3:12:18 PM
    Author     : Duy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
            />
        <link rel="stylesheet" href="style/reset.css" />
        <link rel="stylesheet" href="style/payment-3.css" />
        <title>Payment-3</title>
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
                                        <c:set var="categoryList" value="${sessionScope.CATEGORY}"/>
                                        <c:forEach var="category" items="${categoryList}">
                                            <li class="menu-link-category-tab-title">
                                                <a href="SearchByFilterServlet?txtProductCateID=${category.cateID}" class="menu-link menu-link-bracelet"
                                                   >${fn:toUpperCase(category.name)}</a
                                                >
                                            </li>
                                        </c:forEach>
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
                                                    src="images/shopping-icon-tab.png"
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
                                        <div class="menu-icon-tab-cart-content-function">
                                            <div class="menu-icon-tab-cart-content-function-total">
                                                <p
                                                    class="menu-icon-tab-cart-content-function-total-txt"
                                                    >
                                                    TOTAL AMOUNT
                                                </p>
                                                <p  id="total-price-header"
                                                    class="menu-icon-tab-cart-content-function-total-price"
                                                    >
                                                    <fmt:formatNumber var="price" value="${totalPrice}" pattern="#,###"/>
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
                                     srcset="./../images/shopping-cart.png 2x"
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
                                                <c:set var="cartSize" value="${sessionScope.CART.items.size()}"/>
                                                <c:set var="totalQuantity" value="${0}" />
                                                <c:forEach var="quantity" items="${sessionScope.CART.items.values()}">
                                                    <c:set var="totalQuantity" value="${totalQuantity + quantity}" />
                                                </c:forEach>

                                                <c:if test="${empty sessionScope.CART.items.size()}">
                                                    <c:set var="totalQuantity" value="${0}"/>
                                                </c:if>
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-show-txt-desc"
                                                    >
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
                                        <div class="menu-responsive-icon-tab-cart-content-function">
                                            <div
                                                class="menu-responsive-icon-tab-cart-content-function-total"
                                                >
                                                <p
                                                    class="menu-responsive-icon-tab-cart-content-function-total-txt"
                                                    >
                                                    TOTAL AMOUNT
                                                </p>
                                                <p  id="total-price-mobile"
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
                                                    class="menu-responsive-icon-tab-cart-content-function-method-btn"
                                                    >
                                                    PAY
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="mainPage" class="menu-responsive-logo"> LOGO </a>
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
                <div class="container">
                    <form action="paymentController" method="POST">
                        <div class="shipping-info-left">
                            <c:set var="customerInfomation" value="${sessionScope.USER}"/>
                            <input type="hidden" name="txtCustomerID" value="${customerInfomation.customerID}" />
                            <c:set var = "errors" value="${requestScope.PAYMENT_ERROR}"/>
                            <c:set var = "shippingID" value="${requestScope.SHIPPING_ID}"/>
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
                                <div class="shipping-info-left-title">
                                    <div class="container">
                                        <p class="shipping-info-left-title-txt">Shipping method</p>
                                    </div>
                                </div>

                                <c:forEach items="${SHIPPINGMETHOD_LIST}" var="shippingMethod" varStatus="loop">
                                    <div class="shipping-info-left-form-delivery-home">
                                        <label class="radio-label">
                                            <div class="radio-input">
                                                <input
                                                    type="radio"
                                                    id="location"
                                                    name="location"
                                                    value="${shippingMethod.shippingID}"
                                                    class="input-radio"
                                                    <c:if test="${loop.first}">checked</c:if>
                                                        />
                                                </div>
                                                <span class="radio-label-primary">${shippingMethod.nameOfMethod}</span>
                                        </label>
                                        <div class="shipping-info-left-form-delivery-home-price">
                                            <p class="shipping-info-left-form-delivery-home-price-number">
                                                <input type="hidden" name="txtFee" value="${shippingMethod.transportFee}" />
                                                <fmt:formatNumber var="shippingFee" value="${shippingMethod.transportFee}" pattern="#,##0"/>
                                                                    ${shippingFee}₫
                                            </p>
                                        </div>
                                    </div>
                                </c:forEach>
                                <div class="shipping-info-left-payment">                                  
                                    <div class="shipping-info-left-payment-title">
                                        <div class="container">
                                            <p class="shipping-info-left-payment-title-txt">
                                                Payment Methods
                                            </p>
                                        </div>
                                    </div>
                                    <div class="shipping-info-left-payment-all">
                                        <div class="shipping-info-left-payment-field">                                      

                                            <div class="shipping-info-left-payment-field-input">
                                                <label class="radio-label" id="shipping-info-cod-radio">
                                                    <div class="radio-input">
                                                        <input
                                                            type="radio"
                                                            id="method"
                                                            name="method"
                                                            value="${1}"
                                                            class="input-radio"
                                                            checked
                                                            />
                                                    </div>
                                                    <img
                                                        src="images/cod.svg"
                                                        alt=""
                                                        class="main-img"
                                                        />
                                                    <span class="radio-label-primary"
                                                          >Collecting Household (COD)</span
                                                    >
                                                </label>
                                            </div>
                                        </div>
                                        <div class="shipping-info-left-payment-content-cod">
                                            The customer will pay the product invoice and delivery fee
                                            upon receipt.
                                        </div>
                                        <div class="shipping-info-left-payment-field-other">
                                            <div class="shipping-info-left-payment-field-other-input">
                                                <label class="radio-label" id="shipping-info-other-radio">
                                                    <div class="radio-input">
                                                        <input
                                                            type="radio"
                                                            id="method"
                                                            name="method"
                                                            value="${2}"
                                                            class="input-radio"
                                                            />
                                                    </div>
                                                    <img
                                                        src="images/other.svg"
                                                        alt=""
                                                        class="main-img"
                                                        />
                                                    <span class="radio-label-primary">Bank transfer</span>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="shipping-info-left-payment-content-other">
                                            Customers transfer via bank's number:<br>
                                            0781000487810 - VCB - NGUYEN VAN DUNG <br>
                                            Content: Full name + phone number
                                        </div>
                                    </div>
                                    <c:if test="${not empty errors.paymentIDLengthError}">
                                        <font color="red">
                                        ${errors.paymentIDLengthError}
                                        </font><br/>
                                    </c:if>
                                </div>
                                <button class="shipping-info-left-btn" type="submit">
                                    Complete payment 
                                </button>
                            </div>
                        </div>
                    </form>
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
                                                                <p
                                                                    class="shipping-info-right-product-content-price-number"
                                                                    >
                                                                    <fmt:formatNumber var="price" value="${detail.value.price * item.value}" pattern="#,##0"/>
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
                                            <p class="shipping-info-right-product-fee-name-ship">
                                                Shipping fee
                                            </p>
                                        </div>
                                    </div>
                                    <div class="shipping-info-right-product-fee-price">
                                        <div class="container">
                                            <p
                                                class="shipping-info-right-product-fee-price-provisional"
                                                >
                                                <fmt:formatNumber var="totalDisplay1" value="${total}" pattern="#,##0"/>
                                                                    ${totalDisplay1}₫
                                            </p>
                                            <p class="shipping-info-right-product-fee-price-ship">
                                                <fmt:formatNumber var="txtDefaultShip" value="${sessionScope.SHIPPINGMETHOD_LIST.get(0).getTransportFee()}" pattern="#,##0"/>
                                                <span id="shipping-fee">${txtDefaultShip}</span>₫
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                            
                            <input type="hidden" name="txtHiddenTotal" value="${total}" />
                            <div class="shipping-info-right-product-total">
                                <div class="container">
                                    <div class="shipping-info-right-product-total-name">
                                        <div class="container">
                                            <p class="shipping-info-right-product-total-name-title">
                                                Total
                                            </p>
                                        </div>
                                    </div>
                                    <div class="shipping-info-right-product-total-price">
                                        <div class="container">
                                            <p
                                                class="shipping-info-right-product-total-price-country"
                                                >
                                                
                                            </p>
                                            <p id="total-price-all-product" class="shipping-info-right-product-total-price-number"
                                               style="color: red;">
                                                <fmt:formatNumber var="totalDisplay2" value="${total + sessionScope.SHIPPINGMETHOD_LIST.get(0).getTransportFee()}" pattern="#,##0"/>
                                                <c:set var="totalPrice" value="${total + sessionScope.SHIPPINGMETHOD_LIST.get(0).getTransportFee()}" scope="session" />
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


        <script src="js/payment.js"></script>
        <script src="js/handleEvent.js"></script>
        <script src="js/header.js"></script>
        <script src="js/handleEvent1.js"></script>
    </body>
</html>
