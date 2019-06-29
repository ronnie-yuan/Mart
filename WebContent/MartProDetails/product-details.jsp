<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Product Details</title>
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
                        <h2 class="font--40 mb--0">Product Details</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Breadumb Area -->

    <div class="main-wrapper">
        <!-- Start Single Product -->
        <div class="brook-single-product plr--160 plr_lg--100 plr_md--50 plr_sm--50">
            <div class="single-product-wrapper ptb--120">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="single-product-left-side">
                            <div class="product__details__container">
                                <div class="tab_container big_img_container">
                                    <div class="big_img tab-pane fade show active" id="img1" role="tabpanel">
                                        <img class="w-100" src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </div>
                                    <div class="big_img tab-pane fade" id="img2" role="tabpanel">
                                        <img class="w-100" src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </div>
                                    <div class="big_img tab-pane fade" id="img3" role="tabpanel">
                                        <img class="w-100" src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </div>
                                    <div class="big_img tab-pane fade" id="img4" role="tabpanel">
                                        <img class="w-100" src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </div>
                                    <div class="big_img tab-pane fade" id="img5" role="tabpanel">
                                        <img class="w-100" src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </div>
                                </div>
                                <div class="sm_roduct_nav nav nav-tabs" role="tablist">
                                    <a class="active" id="img1-tab" data-toggle="tab" href="#img1" role="tab" aria-controls="img1" aria-selected="true">
                                        <img src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </a>
                                    <a id="nav-img2-tab" data-toggle="tab" href="#img2" role="tab" aria-controls="img2" aria-selected="false">
                                        <img src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </a>
                                    <a id="nav-img3-tab" data-toggle="tab" href="#img3" role="tab" aria-controls="img3" aria-selected="false">
                                        <img src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </a>
                                    <a id="nav-img4-tab" data-toggle="tab" href="#img4" role="tab" aria-controls="img4" aria-selected="false">
                                        <img src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </a>
                                    <a id="nav-img5-tab" data-toggle="tab" href="#img5" role="tab" aria-controls="img5" aria-selected="false">
                                        <img src="${shopDetails.proImg }" alt="gomes restaurant">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12 mt_sm--40">
                        <div class="single-product-details-side">
                            <div class="product-details">
                                <div class="inner">
                                    <div class="header">
                                        <div class="product-badges">
                                            <span>Hot</span>
                                        </div>
                                        <h4 class="heading heading-h4">${shopDetails.proName }</h4>
                                    </div>

                                    <div class="price">
                                        <p class="theme-color">$ ${shopDetails.proPrice }</p>
                                    </div>

                                    <div class="description">
                                        <p class="bk_pra">${shopDetails.proDescription }</p>
                                    </div>

                                    <div class="quenty-container">
                                        

                                        <div class="product-action">
                                            <a class="addtocart" href="javascript:void(0);" onclick="addCart(${shopDetails.proId})"><i
                                                    class="fa fa-cart-arrow-down"></i><span>Add
                                                    to cart</span></a>
                                            <a class="wislist" href="javascript:void(0);" onclick="addWishlist(${shopDetails.proId})"></a>
                                        </div>
                                    </div>

                                    <div class="product-meta">
                                        <div class="meta-item">
                                            <h6 class="heading heading-h6">CATEGORY:</h6>
                                            <div class="item-list">
                                                <a href="#">Design,</a>
                                                <a href="#">shirt,</a>
                                                <a href="#">Red,</a>
                                                <a href="#">Business,</a>
                                            </div>
                                        </div>
                                        <div class="meta-item">
                                            <h6 class="heading heading-h6">TAG:</h6>
                                            <div class="item-list">
                                                <a href="#">standard,</a>
                                                <a href="#">business,</a>
                                                <a href="#">multipurpose,</a>
                                                <a href="#">createtive,</a>
                                                <a href="#">clean,</a>
                                                <a href="#">themplate,</a>
                                                <a href="#">theme,</a>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Single Product -->

        <!-- Start Product Review -->
        <div class="product_review pb--80 pb_md--80 pb_sm--60">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="description_nav nav nav-tabs d-block" role="tablist">
                            <a class="active" id="descrip-tab" data-toggle="tab" href="#descrip" role="tab" aria-controls="descrip" aria-selected="true">Description</a>
                            <a id="nav-review" data-toggle="tab" href="#review" role="tab" aria-controls="review" aria-selected="false">Reviews</a>
                        </div>
                    </div>
                </div>
                <div class="tab_container">
                    <div class="single_review_content tab-pane fade show active" id="descrip" role="tabpanel">
                        <div class="content">
                            <p>On the other hand, we denounce with righteous indignation and dislike men who are so
                                beguiled and demoralized by the charms. On the other hand, we denounce with righteous
                                indignation and dislike men who are so beguiled and demoralized by the charms. </p>
                        </div>
                    </div>
                    <div class="single_review_content tab-pane fade" id="review" role="tabpanel">
                        <div class="classs__review__inner">
                            <h4>Be the first to review “Gold Plated Desk Lantern Lamp”</h4>
                            <p>Your E-mail Address Will not be published. Required field are marked *</p>
                            <span>Your rating</span>
                            <ul class="rating">
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i> </li>
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i></li>
                            </ul>
                            <form action="#">
                                <div class="input__box">
                                    <span>Your Review *</span>
                                    <textarea name="message"></textarea>
                                </div>
                                <div class="input__box">
                                    <span>Name*</span>
                                    <input type="text">
                                </div>
                                <div class="input__box">
                                    <span>E-mail*</span>
                                    <input type="email">
                                </div>
                                <div class="submit__btn2 mt--30">
                                    <a class="product-btn" href="#">Post
                                        Comment</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Product Review -->


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
	<script src="MyStatic/js/jquery-1.11.3.js"></script>
    <!-- Main JS -->
    <script src="OneStatic/assets/js/main.js"></script>
	<script src="MyStatic/js/MartLi.js"></script>
</body>

</html>

