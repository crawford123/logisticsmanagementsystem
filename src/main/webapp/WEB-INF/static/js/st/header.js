$(function() {
	$(".nav li").hover(function(){
		$(this).find(".move_show").addClass('on_show');
	},function(){
		$(this).find(".move_show").removeClass('on_show')
	});

	$(".sto_lang").hover(function(){
		$(this).find(".sto_select_lang").addClass('on_show');
	},function(){
		$(this).find(".sto_select_lang").removeClass('on_show')
	});

	$( ".code_group li" ).hover( function ()
	{
		$(this).find(".mask_code").addClass('on_show');
	},function(){
		$(this).find(".mask_code").removeClass('on_show')
	});

	$(window).scroll(function() {
		if($(this).scrollTop() != 0) {
			$('.toTop').fadeIn();
		} else {
			$('.toTop').fadeOut();
		}
	});

	$('.toTop').click(function() {
		$('body,html').animate({scrollTop:0},400);
	});
    //��ʼ������ѡ����
	var $citypicker3 = $( '#city-picker' );

    //tab�л�
	$( ".news_top li" ).click( function ()
	{
	    $( this ).addClass( 'active' ).siblings().removeClass( 'active' );
	} );

    //tab�л�
	$( 'body' ).on( 'click', '.nav .nav_list li', function ()
	{
	    $( this ).addClass( 'active' ).siblings().removeClass( 'active' );
	} )
	//$( ".nav li" ).click( function ()
	//{
	//    $( this ).addClass( 'active' ).siblings().removeClass( 'active' );
	//} );

    ////banner �л�
	//var swiper = new Swiper( '.swiper-container', {
	//    pagination: '.swiper-pagination',
	//    nextButton: '.swiper-button-next',
	//    prevButton: '.swiper-button-prev',
	//    paginationClickable: true,
	//    spaceBetween: 30,
	//    centeredSlides: true,
	//    autoplay: 2500,
	//    autoplayDisableOnInteraction: false
	//} );

	var mySwiper = new Swiper( '.swiper-container', {
	    pagination: '.pagination',
	    loop: true,
	    grabCursor: true,
	    paginationClickable: true
	} );
	$( 'body' ).on( 'click', '.arrow-left', function ( e )
	{
	    mySwiper.swipePrev()
	} );
	$( 'body' ).on( 'click', '.arrow-right', function ( e )
	{
	    mySwiper.swipeNext()
	} )

})