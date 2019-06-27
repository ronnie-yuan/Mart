<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Checkout</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    

    <!-- CSS
	============================================ -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="OneStatic/assets/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="OneStatic/assets/css/plugins/plugins.css">

    <!-- Vendor & Plugins CSS (Please remove the comment from below vendor.min.css & plugins.min.css for better website load performance and remove css files from avobe) -->
    <!--
    <script src="OneStatic/assets/js/vendor/vendor.min.js"></script>
    <script src="OneStatic/assets/js/plugins/plugins.min.js"></script>
    -->

    <!-- Main Style CSS (Please use minify version for better website load performance) -->
    <link rel="stylesheet" href="OneStatic/assets/css/style.css">
    <!--<link rel="stylesheet" href="OneStatic/assets/css/style.min.css">-->

</head>

<body>
    <!-- Start Breadumb Area -->
    <div class="breadcumb-area ptb--100 ptb_md--100 ptb_sm--100  bg_image bg_image--3">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="inner text-center">
                        <h2 class="font--40 mb--0">Checkout</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Breadumb Area -->
    <div class="main-wrapper">

        <!-- Checkout Page Start -->
        <div class="checkout_area pt--120 pt_md--80 pt_sm--80 pb--60 bg-color" data-bg-color="#ffffff">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <!-- Checkout Form s-->
                        <form action="#" class="checkout-form">
                            <div class="row">
                                <div class="col-lg-7 mb--20">
                                    <!-- Billing Address -->
                                    <div id="billing-form" class="mb--40">
                                        <h4 class="checkout-title">Billing Address</h4>

                                        <div class="row">

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>First Name*</label>
                                                <input type="text" placeholder="First Name">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Last Name*</label>
                                                <input type="text" placeholder="Last Name">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Email Address*</label>
                                                <input type="email" placeholder="Email Address">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Phone no*</label>
                                                <input type="text" placeholder="Phone number">
                                            </div>

                                            <div class="col-12 mb--20">
                                                <label>Company Name</label>
                                                <input type="text" placeholder="Company Name">
                                            </div>

                                            <div class="col-12 mb--20">
                                                <label>Address*</label>
                                                <input type="text" placeholder="Address line 1">
                                                <input type="text" placeholder="Address line 2">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Country*</label>
                                                <select class="nice-select">
                                                    <option>Bangladesh</option>
                                                    <option>China</option>
                                                    <option>country</option>
                                                    <option>India</option>
                                                    <option>Japan</option>
                                                </select>
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Town/City*</label>
                                                <input type="text" placeholder="Town/City">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>State*</label>
                                                <input type="text" placeholder="State">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Zip Code*</label>
                                                <input type="text" placeholder="Zip Code">
                                            </div>

                                            <div class="col-12 mb--20">
                                                <div class="check-box">
                                                    <input type="checkbox" id="create_account">
                                                    <label for="create_account">Create an Acount?</label>
                                                </div>
                                                <div class="check-box">
                                                    <input type="checkbox" id="shiping_address" data-shipping>
                                                    <label for="shiping_address">Ship to Different Address</label>
                                                </div>
                                            </div>

                                        </div>

                                    </div>

                                    <!-- Shipping Address -->
                                    <div id="shipping-form" class="mb--40">
                                        <h4 class="checkout-title">Shipping Address</h4>

                                        <div class="row">

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>First Name*</label>
                                                <input type="text" placeholder="First Name">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Last Name*</label>
                                                <input type="text" placeholder="Last Name">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Email Address*</label>
                                                <input type="email" placeholder="Email Address">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Phone no*</label>
                                                <input type="text" placeholder="Phone number">
                                            </div>

                                            <div class="col-12 mb--20">
                                                <label>Company Name</label>
                                                <input type="text" placeholder="Company Name">
                                            </div>

                                            <div class="col-12 mb--20">
                                                <label>Address*</label>
                                                <input type="text" placeholder="Address line 1">
                                                <input type="text" placeholder="Address line 2">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Country*</label>
                                                <select class="nice-select">
                                                    <option>Bangladesh</option>
                                                    <option>China</option>
                                                    <option>country</option>
                                                    <option>India</option>
                                                    <option>Japan</option>
                                                </select>
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Town/City*</label>
                                                <input type="text" placeholder="Town/City">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>State*</label>
                                                <input type="text" placeholder="State">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Zip Code*</label>
                                                <input type="text" placeholder="Zip Code">
                                            </div>

                                        </div>

                                    </div>

                                </div>

                                <div class="col-lg-5">
                                    <div class="row">

                                        <!-- Cart Total -->
                                        <div class="col-12 mb--60">

                                            <h4 class="checkout-title">Cart Total</h4>

                                            <div class="checkout-cart-total">

                                                <h4>Product <span>Total</span></h4>

                                                <ul>
                                                    <li>Samsome Notebook Pro 5 X 01 <span>$295.00</span></li>
                                                    <li>Aquet Drone D 420 X 02 <span>$550.00</span></li>
                                                    <li>Play Station X 22 X 01 <span>$295.00</span></li>
                                                    <li>Roxxe Headphone Z 75 X 01 <span>$110.00</span></li>
                                                </ul>

                                                <p>Sub Total <span>$1250.00</span></p>
                                                <p>Shipping Fee <span>$00.00</span></p>

                                                <h4>Grand Total <span>$1250.00</span></h4>

                                            </div>

                                        </div>

                                        <!-- Payment Method -->
                                        <div class="col-12 mb--60">

                                            <h4 class="checkout-title">Payment Method</h4>

                                            <div class="checkout-payment-method">

                                                <div class="single-method">
                                                    <input type="radio" id="payment_check" name="payment-method" value="check">
                                                    <label for="payment_check">Check Payment</label>
                                                    <p data-method="check">Please send a Check to Store name with Store
                                                        Street, Store Town, Store State, Store Postcode, Store Country.
                                                    </p>
                                                </div>

                                                <div class="single-method">
                                                    <input type="radio" id="payment_bank" name="payment-method" value="bank">
                                                    <label for="payment_bank">Direct Bank Transfer</label>
                                                    <p data-method="bank">Please send a Check to Store name with Store
                                                        Street, Store Town, Store State, Store Postcode, Store Country.
                                                    </p>
                                                </div>

                                                <div class="single-method">
                                                    <input type="radio" id="payment_cash" name="payment-method" value="cash">
                                                    <label for="payment_cash">Cash on Delivery</label>
                                                    <p data-method="cash">Please send a Check to Store name with Store
                                                        Street, Store Town, Store State, Store Postcode, Store Country.
                                                    </p>
                                                </div>

                                                <div class="single-method">
                                                    <input type="radio" id="payment_paypal" name="payment-method" value="paypal">
                                                    <label for="payment_paypal">Paypal</label>
                                                    <p data-method="paypal">Please send a Check to Store name with Store
                                                        Street, Store Town, Store State, Store Postcode, Store Country.
                                                    </p>
                                                </div>

                                                <div class="single-method">
                                                    <input type="radio" id="payment_payoneer" name="payment-method" value="payoneer">
                                                    <label for="payment_payoneer">Payoneer</label>
                                                    <p data-method="payoneer">Please send a Check to Store name with
                                                        Store Street, Store Town, Store State, Store Postcode, Store
                                                        Country.</p>
                                                </div>

                                                <div class="single-method">
                                                    <input type="checkbox" id="accept_terms">
                                                    <label for="accept_terms">I’ve read and accept the terms &
                                                        conditions</label>
                                                </div>

                                            </div>

                                            <button class="place-order">Place order</button>

                                        </div>

                                    </div>
                                </div>

                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <!-- Checkout Page End -->

    </div>

    <!-- Quick View Modal -->
    <div class="quick-view-modal">
        <div class="quick-view-modal-inner">
            <div class="container">
                <div class="product-details">
                    <!-- Product Details Left -->
                    <div class="product-details-left">
                        <div class="product-details-images slider-navigation-2">
                            <a href="#">
                                <img class="w-100" src="OneStatic/assets/images/product/product-01.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src="OneStatic/assets/images/product/product-02.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src="OneStatic/assets/images/product/product-03.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src="OneStatic/assets/images/product/product-04.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src="OneStatic/assets/images/product/product-05.jpg" alt="product image">
                            </a>
                        </div>
                        <div class="product-details-thumbs slider-navigation-2">
                            <img src="OneStatic/assets/images/product/product-01.jpg" alt="product image thumb">
                            <img src="OneStatic/assets/images/product/product-02.jpg" alt="product image thumb">
                            <img src="OneStatic/assets/images/product/product-03.jpg" alt="product image thumb">
                            <img src="OneStatic/assets/images/product/product-04.jpg" alt="product image thumb">
                            <img src="OneStatic/assets/images/product/product-05.jpg" alt="product image thumb">
                        </div>
                    </div>
                    <!--// Product Details Left -->

                    <!-- Product Details Right -->
                    <div class="product-details-right">
                        <h5 class="product-title">Demo Product Name</h5>

                        <div class="ratting-stock-availbility">
                            <div class="ratting-box">
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                            </div>
                            <span class="stock-available">In stock</span>
                        </div>

                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue nec est
                            tristique auctor. Donec non est at libero vulputate rutrum. Morbi ornare lectus quis
                            justo gravida semper. Nulla tellus mi, vulputate adipiscing cursus eu, suscipit id
                            nulla. adipiscing cursus eu, suscipit id nulla.</p>

                        <div class="price-box">
                            <span class="pricebox-price">£80.00</span>
                        </div>

                        <div class="product-details-quantity">
                            <div class="quantity-select">
                                <div class="pro-quantity">
                                    <div class="pro-qty"><input type="text" value="1"></div>
                                </div>
                            </div>
                            <a href="#" class="add-to-cart-button">
                                <span>ADD TO CART</span>
                            </a>
                        </div>

                        <div class="product-details-color">
                            <span>Color :</span>
                            <ul>
                                <li class="red"><span></span></li>
                                <li class="green checked"><span></span></li>
                                <li class="blue"><span></span></li>
                                <li class="black"><span></span></li>
                            </ul>
                        </div>

                        <div class="product-details-size">
                            <span>Size :</span>
                            <ul>
                                <li class="checked"><span>S</span></li>
                                <li><span>M</span></li>
                                <li><span>L</span></li>
                                <li><span>XL</span></li>
                                <li><span>XXL</span></li>
                            </ul>
                        </div>

                        <div class="product-details-categories">
                            <span>Categories :</span>
                            <ul>
                                <li><a href="shop.jsp">Accessories</a></li>
                                <li><a href="shop.jsp">Kids</a></li>
                                <li><a href="shop.jsp">Women</a></li>
                            </ul>
                        </div>

                        <div class="product-details-tags">
                            <span>Tags :</span>
                            <ul>
                                <li><a href="shop.jsp">Electronic</a></li>
                                <li><a href="shop.jsp">Television</a></li>
                            </ul>
                        </div>

                        <div class="product-details-socialshare">
                            <span>Share :</span>
                            <ul>
                                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a class="google-plus" href="#"><i class="fa fa-google-plus"></i></a></li>
                                <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <!--// Product Details Right -->

                </div>
            </div>
        </div>
        <button class="close-quickview-modal"><i class="fa fa-close"></i></button>
    </div>
    <!--// Quick View Modal -->
    <!-- Start Footer Area -->
    <footer class="footer-area bg-color plr--100 plr_lg--40 plr_md--30 plr_sm--30 clearfix" data-bg-color="#f4f8fa">
        <!-- Start Footer Top -->
        <div class="footer-top ptb--80">
            <div class="row">
                <div class="col-custom--5">
                    <div class="footer-widget">
                        <div class="logo">
                            <a href="index.jsp">
                                <img src="OneStatic/assets/images/logo/logo-black.png" alt="Logo">
                            </a>
                        </div>
                        <div class="inner">
                            <p>On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms. </p>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_mobile--40">
                    <div class="footer-widget">
                        <h5 class="title">Company</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">About US</a></li>
                                <li><a href="#">Blogs</a></li>
                                <li><a href="#">Careers</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_md--40 mt_sm--40">
                    <div class="footer-widget">
                        <h5 class="title">Product</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">Pricing</a></li>
                                <li><a href="#">Features</a></li>
                                <li><a href="#">Customers</a></li>
                                <li><a href="#">Demos</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_md--40 mt_sm--40">
                    <div class="footer-widget">
                        <h5 class="title">Helps</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">Introduction</a></li>
                                <li><a href="#">Feedback</a></li>
                                <li><a href="#">Referrals</a></li>
                                <li><a href="#">Network Status</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_md--40 mt_sm--40">
                    <div class="footer-widget">
                        <h5 class="title">Social Netowrk</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">Facebook</a></li>
                                <li><a href="#">Twitter</a></li>
                                <li><a href="#">Linkedin</a></li>
                                <li><a href="#">Google +</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Footer Top -->
        <!-- Start Footer Middle -->
        <div class="footer-middle">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer-middle-inner ptb--45 text-center">
                            <div class="tags-list">
                                <span>Tags :</span>
                                <div class="tags">
                                    <a href="#">Minimal eCommerce</a>
                                    <a href="#">Marketing</a>
                                    <a href="#">User Exprience</a>
                                    <a href="#">Ali Express</a>
                                    <a href="#">Web</a>
                                    <a href="#">Digital Expo</a>
                                    <a href="#">Web Search</a>
                                    <a href="#">Affiliate</a>
                                    <a href="#">UCWeb</a>
                                    <a href="#">Support</a>
                                    <a href="#">Theme</a>
                                    <a href="#">Best Queality</a>
                                    <a href="#">Mobile</a>
                                    <a href="#">24 Support</a>
                                    <a href="#">Ali Express</a>
                                    <a href="#">Web</a>
                                    <a href="#">Laptop</a>
                                    <a href="#">Web Search</a>
                                    <a href="#">Affiliate</a>
                                    <a href="#">Photoshop</a>
                                    <a href="#">Support</a>
                                    <a href="#">Theme</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Footer Middle -->
        <!-- Start Copyright -->
        <div class="copyright-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="copyright-inner ptb--25 text-center">
                            <p class="mb--0">Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Copyright -->
    </footer>
    <!-- End Footer Area -->















    <!-- JS
============================================ -->

    <!-- Modernizer JS -->
    <script src="OneStatic/assets/js/vendor/modernizr.min.js"></script>
    <!-- jQuery JS -->
    <script src="OneStatic/assets/js/vendor/jquery.js"></script>
    <!-- Bootstrap JS -->
    <script src="OneStatic/assets/js/vendor/bootstrap.min.js"></script>
    <script src="OneStatic/assets/js/plugins/plugins.js"></script>
    <!-- Vendor & Plugins JS (Please remove the comment from below vendor.min.js & plugins.min.js for better website load performance and remove js files from avobe) -->
    <!--
<script src="OneStatic/assets/js/vendor/vendor.min.js"></script>
<script src="OneStatic/assets/js/plugins/plugins.min.js"></script>
-->

    <!-- Main JS -->
    <script src="OneStatic/assets/js/main.js"></script>

</body>

</html>

