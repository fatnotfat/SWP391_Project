<%-- 
    Document   : signUp
    Created on : Oct 20, 2022, 9:06:54 AM
    Author     : Chau Nhat Truong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ page language="java"
contentType="text/html;
charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="style/reset.css" />
        <link rel="stylesheet" href="style/register.css" />
        <title>Sign Up</title>
    </head>
    <body>
        <div class="wrapper">
            <header class="header">
                <div class="nav-top">
                    <div class="container">
                        <div class="shipping">
                            <p class="shipping-text">Free shipping with recept from 200$</p>
                        </div>
                    </div>
                </div>
                <img src="images/Nav-line.png" alt="" />
                <!-- NAV DESKTOP - TABLET -->
                <div class="nav-bot">
                    <div class="container">
                        <a href="mainPage" class="menu-logo"> LOGO </a>
                        <ul class="menu">
                            <!--                            <li class="menu-item">
                                                            <a href="searchByFilterPage" class="menu-link">Categories</a>
                                                        </li>-->
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
                                                    srcset="images/shopping-icon-tab.png 2x"
                                                    alt=""
                                                    />
                                            </div>
                                            <div class="menu-icon-tab-cart-content-show-txt">
                                                <p class="menu-icon-tab-cart-content-show-txt-desc">
                                                    There are currently no products
                                                </p>
                                            </div>
                                        </div>
                                        <img srcset="images/Footer-line.png 2x" alt="" />
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
                                                    0₫
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
                            <img
                                class="menu-responsive-icon-img"
                                srcset="images/shopping-cart.png 2x"
                                alt=""
                                />
                        </div>
                        <a href="#!" class="menu-responsive-logo"> LOGO </a>
                        <div class="menu-responsive-icon">
                            <img
                                class="menu-responsive-icon-img"
                                srcset="images/textalign-justifycenter.png 2x"
                                alt=""
                                />
                        </div>
                    </div>
                </div>
                <!--  -->
            </header>
            <img src="images/Nav-line.png" alt="" />
            <div class="register">
                <div class="container">
                    <div class="register-heading">
                        <h1>Register</h1>
                    </div>
                    <img class="register-space" src="images/Login-line.png" alt="" />
                    <img class="register-space-mobile" srcset="images/register-line-mobile.png 2x" alt="" />
                    <c:set var="SIGNUP_URL" value="signUpPage" scope="session"/>
                    <form action="signUpController" method="POST">
                        <div class="register-form-container">
                            <div class="register-form">
                                <div class="register-form-control">
                                    <c:set var = "errors" value="${requestScope.SIGNUP_ERROR}"/>
                                    <input type="text" name="txtFirstName"
                                           class="register-input-first-name"
                                           placeholder="First name"
                                           value="" /><br/>
                                </div>
                                <div class="register-form-control">
                                    <c:if test="${not empty errors.firstNameLengthError}">
                                        <small color="red">
                                            ${errors.firstNameLengthError}
                                        </small><br/>
                                    </c:if>
                                </div>
                                <div class="register-form-control">
                                    <input type="text" name="txtLastName"
                                           class="register-input-last-name"
                                           placeholder="Last name"
                                           value="" /><br/>
                                    <c:if test="${not empty errors.lastNameLengthError}">
                                        <small color="red">
                                            ${errors.lastNameLengthError}
                                        </small><br/>
                                    </c:if>
                                </div>
                                <div class="register-form-gender">
                                    <br/>
                                    <div class="register-form-radio">
                                        <input type="radio" name="txtSex"
                                               class="register-form-input-radio"
                                               id="gender-male"
                                               value="Male" checked/>
                                        <span class="register-form-input-check-logo"></span>
                                        <label for="gender-male" class="register-form-input-male"
                                               >Male</label>
                                    </div>
                                    <div class="register-form-radio">
                                        <input type="radio" name="txtSex"
                                               class="register-form-input-radio"
                                               id="gender-female"value="Female"/>
                                        <span class="register-form-input-check-logo"></span>
                                        <label for="gender-female" class="register-form-input-female"
                                               >Female</label>
                                    </div>
                                </div>
                                <div class="register-form-control">
                                    <input type="date" name="txtBirthDate"
                                           class="register-input-date"
                                           id="date"
                                           placeholder="mm/dd/yyyy"
                                           value="${param.txtBirthDate}" /><br/>
                                    <c:if test="${not empty errors.birthDateLengthError}">
                                        <small color="red">
                                            ${errors.birthDateLengthError}
                                        </small><br/>
                                    </c:if>
                                </div>
                                <div class="register-form-control">
                                    <input type="text" name="txtEmail"
                                           class="register-input-email"
                                           placeholder="Email"
                                           value="${param.txtEmail}" /><br/>
                                    <c:if test="${not empty errors.emailLengthError}">
                                        <small color="red">
                                            ${errors.emailLengthError}
                                        </small><br/>
                                    </c:if>
                                </div>
                                <div class="register-form-control">
                                    <c:if test="${not empty errors.emailIsExisted}">
                                        <small color="red">
                                            ${errors.emailIsExisted}
                                        </small>><br/>
                                    </c:if>
                                </div>
                                <div class="register-form-control">
                                    <input type="password" name="txtPassword"
                                           class="register-input-password"
                                           placeholder="Password"
                                           value="" /> (e.g, 6 - 30 chars)<br/>
                                    <c:if test="${not empty errors.passwordLengthError}">
                                        <small color="red">
                                            ${errors.passwordLengthError}
                                        </small><br/>
                                    </c:if>
                                </div>
                                <div class="register-form-control">
                                    <input type="password" name="txtConfirm"
                                           class="register-input-confirm-password"
                                           placeholder="Confirm Password"
                                           value="" /><br/>
                                    <c:if test="${not empty errors.confirmNotMatched}">
                                        <small color="red">
                                            ${errors.confirmNotMatched}
                                        </small><br/>
                                    </c:if>
                                </div>
                            </div>
                            <div class="register-function">
                                <p class="register-function-security">
                                    This site is protected by reCAPTCHA and the Google
                                    <a href="https://policies.google.com/terms">Privacy Policy</a>
                                    and
                                    <a href="https://policies.google.com/privacy"
                                       >Terms of Service</a>
                                    apply.
                                </p>
                                <!--                                <input class="register-function-btn"
                                                                       type="submit" value="Sign up"
                                                                       name="btAction" /><br/>-->
                                <button class="register-function-btn" type="submit">Sign up</button>
                                <p class="register-function-register">
                                    <span class="register-function-register-question">
                                        Already have an account?
                                    </span> <a href="loginPage" class="register-function-register-hightlight" >Login</a> here<br/>
                                </p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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
                                <p class="footer-menu-cus-service-desc-txt">
                                    TERMS OF SERVICE
                                </p>
                                <p class="footer-menu-cus-service-desc-txt">
                                    REFUND POLICY
                                </p>
                            </div>
                        </div>
                        <div class="footer-menu-about">
                            <h3 class="footer-menu-about-title">ABOUT US</h3>
                            <div class="footer-menu-about-desc">
                                <p class="footer-menu-about-desc-txt">
                                    STORY OF PDTK
                                </p>
                            </div>
                        </div>
                        <div class="footer-menu-care">
                            <h3 class="footer-menu-care-title">FOR CUSTOMERS</h3>
                            <div class="footer-menu-care-desc">
                                <p class="footer-menu-care-desc-txt">
                                    INSTRUCTIONS FOR STORAGE OF US PRODUCTS
                                </p>
                                <p class="footer-menu-care-desc-txt">
                                    FASHION KNOWLEDGE
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-copyright">
                    <div class="container">
                        <p class="footer-copyright-txt">
                            © 2023 PTDK All Rights Reserved.
                        </p>
                    </div>
                </div>
            </footer>
        </div>
        <script src="js/register.js"></script>
        <script src="js/handleEvent.js"></script>
        <script src="js/header.js"></script>
        <script src="js/handleEvent1.js"></script>
    </body>   
</html>
