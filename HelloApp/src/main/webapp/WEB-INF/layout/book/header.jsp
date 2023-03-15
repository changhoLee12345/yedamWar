<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Demo styles -->
<style>
  html,
  body {
    position: relative;
    height: 100%;
  }

  body {
    background: #eee;
    font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
    font-size: 14px;
    color: #000;
    margin: 0;
    padding: 0;
  }

  .swiper {
    width: 100%;
    height: 100%;

  }

  .swiper-slide {
    text-align: center;
    font-size: 18px;
    background: #fff;

    /* Center slide text vertically */
    display: -webkit-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    -webkit-align-items: center;
    align-items: center;
  }
</style>

<header class="py-5">
  <div class="container px-lg-5">
    <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
      <!-- <div class="m-4 m-lg-5">
        <h1 class="display-5 fw-bold">A warm welcome!</h1>
        <p class="fs-4">Bootstrap utility classes are used to create this jumbotron since the old component has
          been removed from the framework. Why create custom CSS when you can use utilities?</p>
        <a class="btn btn-primary btn-lg" href="#!">Call to action</a>
      </div> -->


      <!-- Swiper -->
      <div class="swiper">
        <div class="swiper-wrapper">
          <div class="swiper-slide"><img src="./resources/images/book1.png"></div>
          <div class="swiper-slide"><img src="./resources/images/book2.png"></div>
          <div class="swiper-slide"><img src="./resources/images/book3.png"></div>
          <div class="swiper-slide"><img src="./resources/images/book4.png"></div>
          <div class="swiper-slide"><img src="./resources/images/book5.png"></div>
          <div class="swiper-slide"><img src="./resources/images/book6.png"></div>
        </div>
        <!-- Add Pagination -->
        <div class="swiper-pagination"></div>
        <!-- Add Arrows -->
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
      </div>

    </div>
  </div>
</header>


<!-- Initialize Swiper -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />

<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

<script>
  var swiper = new Swiper('.swiper', {
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,
    },
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });
</script>