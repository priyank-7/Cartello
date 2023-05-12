<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


</head>


<body>




	<!-- Navbar Starting -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light py-3">
		<a class="navbar-brand" href="#"> <span>Shop Online</span> <i
			class="fa-solid fa-truck-fast fa-2xl" style="color: #2756c4;"></i></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item dropdown border-left"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Categories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<c:forEach items="${category }" var="cat">
							<a class="dropdown-item" href="${pageContext.request.contextPath }/products/${cat.getId() }">${cat.categoryName }</a>
						</c:forEach>

					</div></li>
				<li class="nav-item border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/">Home <i
						class="fa-solid fa-house fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/cart">Cart <i class="fa-solid fa-cart-shopping fa-lg"
						style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/wishlist">Wish List <i class="fa-solid fa-heart fa-beat fa-lg"
						style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left">
				<c:set var="user" scope="session" value="${currentuser}" /> 				
						<c:choose>
						<c:when test="${user == null}">  
       						<a class="nav-link"
					href="${pageContext.request.contextPath }/auth">Login/Register <i class="fa-solid fa-circle-user fa-lg" style="color: #2756c4;"></i></a>
    					</c:when>
						<c:otherwise>  
       						 <a class="nav-link"
					href="${pageContext.request.contextPath }/auth">${user.userId }<i class="fa-solid fa-circle-user fa-lg" style="color: #2756c4;"></i></a>
    					</c:otherwise>
					</c:choose> </li>
			</ul>
			<form action="${pageContext.request.contextPath }\search" class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" name="productName" id="name">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>




	<!-- Navbar Ending -->



	<!-- Image Slider -->

	<div id="carouselExampleIndicators" class="container carousel slide mt-3"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100"
					src="https://images-eu.ssl-images-amazon.com/images/G/31/img21/PC/Computers/GW/DBQC/D21343116_IN_CEPC_BAU_GW_graphics_March21_dbqc0.5x_7._SY116_CB655805757_.jpg"
					alt="First slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="https://images-eu.ssl-images-amazon.com/images/G/31/img21/PC/Computers/GW/DBQC/D21343116_IN_CEPC_BAU_GW_graphics_March21_dbqc0.5x_7._SY116_CB655805757_.jpg"
					alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="https://images-eu.ssl-images-amazon.com/images/G/31/img21/PC/Computers/GW/DBQC/D21343116_IN_CEPC_BAU_GW_graphics_March21_dbqc0.5x_7._SY116_CB655805757_.jpg"
					alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<!-- Image Slider end -->


	<!-- Featured Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5 pb-3">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1 ">
				<div class="d-flex align-items-center bg-light mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-check text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">Quality Product</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center bg-light mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
					<h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center bg-light mb-4"
					style="padding: 30px;">
					<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center bg-light mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- Featured End -->



	<div class="container-fluid pt-5">
		<h2
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="pr-3">Categories</span>
		</h2>
		<div class="row px-xl-5 pb-3">

			<c:forEach items="${category }" var="cat">

				<div class="col-lg-3 col-md-4 col-sm-6 pb-1 ">
					<a class="text-decoration-none" href="${pageContext.request.contextPath }/products/${cat.getId() }">
						<div class="cat-item d-flex align-items-center mb-4 "
							style="background-color: #eceff1">
							<div class="overflow-hidden "
								style="width: 100px; height: 100px;">
								<img class="img-fluid mt-2 ml-2"
									src="https://images-eu.ssl-images-amazon.com/images/G/31/img21/PC/Computers/GW/DBQC/D21343116_IN_CEPC_BAU_GW_graphics_March21_dbqc0.5x_7._SY116_CB655805757_.jpg"
									alt="">
							</div>
							<div class="flex-fill pl-3">
								<h6>${cat.categoryName } ${cat.id }</h6>
							</div>
						</div>
					</a>
				</div>

			</c:forEach>

		</div>
	</div>
















</body>

</html>