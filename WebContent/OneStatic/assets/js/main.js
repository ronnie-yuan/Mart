/*********************************************************************************

	Template Name: Lanes Bootstrap4 Ecommerce Template
	Note: This is Main JS Here.

**********************************************************************************/


/*==========================
	Main Js Index 

    	01. Wow Active 
    	02. Youtub Popup
		03. Click Shopping Cart
		04. Bg Color
		05. Countdown
		06. Quick View Modal
		07. Product Details Images 
		08. Slider Activation
	   	09. Quantity
		10. Hambargur Option
		11. Scroll Up Activation
		12. Shipping Form Toggle
		13. Payment Method Select
		14. Add To Cart Animation
        15. Price Slider Active
==============================*/

(function ($) {

	'use strict';

    /*======================= 
    	01. Wow Active 
    ======================*/

    new WOW().init();

	/*=========================== 
    	02. Youtub Popup 
    ============================*/

	$('.play__btn').yu2fvl();
	
	/*=============================
		03. Click Shopping Cart 
	================================*/

	function ClcickCart() {
		var body = 'body';
		$('.cart-trigger').on('click', function (e) {
			e.preventDefault(),
				$(body).addClass('open-cart-aside');
		})
		$('.btn-close-cart').on('click', function (e) {
			e.preventDefault(),
				$(body).removeClass('open-cart-aside');
		})
		$('.search-flyoveray').on('click', function (e) {
			e.preventDefault(),
				$(body).removeClass('open-cart-aside');
		})
	}
	ClcickCart();


	/*==================================
		04. Bg Color
	===================================*/

	var $bgcolor = $('.bg-color');
	$bgcolor.each(function () {
		var $this = $(this),
			$color = $this.data('bg-color');
		$this.css('background-color', $color);
	});

	/*============================== 
		05. Countdown
	===============================*/

	$('[data-countdown]').each(function () {
		var $this = $(this),
			finalDate = $(this).data('countdown');
		$this.countdown(finalDate, function (event) {
			$this.html(event.strftime('<span class="ht-count days"><span class="count-inner"><span class="time-count">%-D</span> <p>Days</p></span></span> <span class="ht-count hour"><span class="count-inner"><span class="time-count">%-H</span> <p>Hours</p></span></span> <span class="ht-count minutes"><span class="count-inner"><span class="time-count">%M</span> <p>Minutes</p></span></span> <span class="ht-count second"><span class="count-inner"><span class="time-count">%S</span> <p>Seconds</p></span></span>'));
		});
	});

	/*----------------------------------
		06. Quick View Modal 
	------------------------------------*/
	$('.quickview').on('click', function (e) {
		e.preventDefault();
		$('.quick-view-modal').toggleClass('is-visible');
	});

	$('.close-quickview-modal').on('click', function () {
		$('.quick-view-modal').removeClass('is-visible');
	});

	/*----------------------------------
		07. Product Details Images 
	------------------------------------*/

	$('.product-details-images').slick({
		slidesToShow: 1,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 5000,
		dots: false,
		infinite: true,
		centerMode: true,
		centerPadding: 0,
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-caret-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-caret-right"></i></span>',
		asNavFor: '.product-details-thumbs'
	});

	$('.product-details-thumbs').slick({
		slidesToShow: 3,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 5000,
		dots: false,
		infinite: true,
		focusOnSelect: true,
		centerMode: true,
		centerPadding: 0,
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-caret-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-caret-right"></i></span>',
		asNavFor: '.product-details-images'
	});

	/*----------------------------------
		08. Slider Activation
	------------------------------------*/

	$('.slider-activation').slick({
		slidesToShow: 1,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 5000,
		dots: false,
		infinite: true,
		centerPadding: 0,
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-caret-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-caret-right"></i></span>',
	});

	/*--------------------------------
	   09. Quantity
	-------------------------------*/

	$('.pro-qty').prepend('<span class="dec qtybtn">-</span>');
	$('.pro-qty').append('<span class="inc qtybtn">+</span>');
	$('.qtybtn').on('click', function () {
		var $button = $(this);
		var oldValue = $button.parent().find('input').val();
		if ($button.hasClass('inc')) {
			var newVal = parseFloat(oldValue) + 1;
		} else {
			// Don't allow decrementing below zero
			if (oldValue > 0) {
				var newVal = parseFloat(oldValue) - 1;
			} else {
				newVal = 0;
			}
		}
		$button.parent().find('input').val(newVal);
	});

	/*=============================
		10. Hambargur Option
	================================*/

	function hamburgerOption(params) {
		$('.hamburger-trigger').on('click', function (e) {
			e.preventDefault(),
			$('.hamburger-area').addClass('is-visible');
			$(this).addClass('open');
		})
		$('.btn-close-search').on('click', function (e) {
			e.preventDefault(),
			$(this).parent('.hamburger-area').removeClass('is-visible');
			$('.hamburger-trigger').removeClass('open');
			$('.sub-menu').slideUp('100');
			$('.lavel--3').slideUp('100');
			$('.responsive-manu > li > a').removeClass('is-visiable')
			$('.has-label--3 a').removeClass('is-visiable')
		})
	}
	hamburgerOption();

	function responsiveMenu() {
		$('.responsive-manu > li > a').on('click', function (e) {
			e.preventDefault(),
			$(this).siblings('.sub-menu').slideToggle('400');
			$(this).toggleClass('is-visiable').siblings('.sub-menu').toggleClass('active');
			$('.lavel--3').slideUp('400');
			$('.has-label--3 a').removeClass('is-visiable')
		});
		$('.has-label--3 a').on('click', function (e) {
			e.preventDefault(),
			$(this).siblings('.lavel--3').slideToggle('400');
			$(this).toggleClass('is-visiable').siblings('.sub-menu').toggleClass('active');
		});
	}
	responsiveMenu();


	/*==================================
		11. Scroll Up Activation
	=====================================*/

	$.scrollUp({
		scrollText: '<i class="fa fa-angle-up"></i>',
		easingType: 'linear',
		scrollSpeed: 900,
		animation: 'slide'
	});

	/*================================== 
		12. Shipping Form Toggle
	====================================*/

	$('[data-shipping]').on('click', function () {
		if ($('[data-shipping]:checked').length > 0) {
			$('#shipping-form').slideDown();
		} else {
			$('#shipping-form').slideUp();
		}
	})

	/*==================================
		13. Payment Method Select
	====================================*/
	$('[name="payment-method"]').on('click', function () {
		var $value = $(this).attr('value');
		$('.single-method p').slideUp();
		$('[data-method="' + $value + '"]').slideDown();

	})

	/*----------------------------------
		14. Add To Cart Animation
	------------------------------------*/

	$('.add-to-cart').on('click', function (e) {
		e.preventDefault();

		if ($(this).hasClass('added')) {
			$(this).removeClass('added').find('i').removeClass('fa-check').addClass('fa-cart-plus').siblings('span').text('add to cart');
		} else {
			$(this).addClass('added').find('i').addClass('fa-check').removeClass('fa-cart-plus').siblings('span').text('added');
		}
	});

    /*==============================
        15. Price Slider Active
    ================================*/

    $('#slider-range').slider({
        range: true,
        min: 10,
        max: 500,
        values: [110, 400],
        slide: function (event, ui) {
            $('#amount').val('$' + ui.values[0] + ' - $' + ui.values[1]);
        }
    });
    $('#amount').val('$' + $('#slider-range').slider('values', 0) +
        " - $" + $('#slider-range').slider('values', 1));




})(jQuery)