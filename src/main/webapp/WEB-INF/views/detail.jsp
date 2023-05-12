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
							<a class="dropdown-item"
								href="${pageContext.request.contextPath }/products/${cat.getId() }">${cat.categoryName }</a>
						</c:forEach>

					</div></li>
				<li class="nav-item border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/">Home <i
						class="fa-solid fa-house fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/cart">Cart <i
						class="fa-solid fa-cart-shopping fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/wishlist">Wish List <i
						class="fa-solid fa-heart fa-beat fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><c:set var="user"
						scope="session" value="${currentuser}" /> <c:choose>
						<c:when test="${user == null}">
							<a class="nav-link"
								href="${pageContext.request.contextPath }/auth">Login/Register
								<i class="fa-solid fa-circle-user fa-lg" style="color: #2756c4;"></i>
							</a>
						</c:when>
						<c:otherwise>
							<a class="nav-link"
								href="${pageContext.request.contextPath }/auth">${user.userId }<i
								class="fa-solid fa-circle-user fa-lg" style="color: #2756c4;"></i></a>
						</c:otherwise>
					</c:choose></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>




	<!-- Navbar Ending -->


	<c:set var="prdct" scope="session" value="${product }" />

	<div class="container-fluid">

		<div class="row mt-4">

			<div class="col-md-6 ">
				<div class="p-4 d-flex justify-content-center align-items-center ">
					<div style="height: 90%; width: 90%" class="">
						<img src="${prdct.imageUrl }" style="height: 100%; width: 100%">
					</div>
				</div>
			</div>

			<div class="col-md-6 ">

				<div class="card ml-2 mr-2 d-flex align-items-stretch"
					style="border: none; height: inherit;">
					<div class="card-body">
						<h4 class="card-title">${prdct.productName }</h4>
						<div class="text-muted">${prdct }</div>
						<h1 class="card-title">
							<i class="fa-solid fa-indian-rupee-sign fa-sm"
								style="color: #000000;"></i> ${prdct.price }
						</h1>
						<p class="card-text">${prdct.productSize }</p>
						<p class="card-text">${prdct.productColor }</p>
						<p class="card-text">Rating : 4.5</p>
						<p class="card-text">Product Properties</p>

						<div>
							<form action="${pageContext.request.contextPath }/addtocart/${prdct.productId }" commandName="queryForm">
								<div class="form-row align-items-center">
									<div class="col-auto my-1">
										<label class="mr-sm-2" for="quantity">Quantity</label>
										<select class="custom-select mr-sm-2"
											id="quantity" name="quantity">																	
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>
									</div>
								</div>
								<div>
									<button type="submit" class="btn btn-primary">Add To Cart</button>
								</div>
							</form>
						</div>
											

						<div>
							<div>
								<a
									href="${pageContext.request.contextPath }/addtolist/${prdct.productId }"
									class="btn btn-primary">Add To wishlist</a>
							</div>
						</div>
											
					</div>
				</div>
			</div>
		</div>


		<div class="row mt-3">
			<div class=" col-md-7 ">
				<div class="card text-center">
					<div class="card-header" style="background: none">
						<ul class="nav">
							<li class="nav-item" id="l2" onclick="fun2()"><a
								class="nav-link" href="#">Product Discription</a></li>
							<li id=" class=" nav-item" id="l1" onclick="fun1()"><a
								class="nav-link" href="#">Review</a></li>
						</ul>
					</div>
					<div class="card-body" id="Review">
						<h5 class="card-title">Product Discription</h5>
						<p class="card-text text-left">With supporting text below as a
							natural lead-in to additional content. With supporting text below
							as a natural lead-in to additional content. With supporting text
							below as a natural lead-in to additional content. With supporting
							text below as a natural lead-in to additional content. With
							supporting text below as a natural lead-in to additional content.</p>
					</div>

					<div class="card-body" id="Detail" style="display: none">
						<h5 class="card-title">Special title treatment</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<c:forEach items="${reviews }" var="r">
							${r.reviewId }
							${r.userId }
							${r.productId }
							${r.rating }
							${r.review }
							${r.timestamp }
						</c:forEach>
						<p></p>
						<a href="#" class="btn btn-primary">Go Top</a>
					</div>


				</div>
			</div>


			<div class="col-md-5 border">

				<div class="p-2  text-center">
					<h1>Review Form</h1>

					<form class="text-left ml-2"
						action="${pageContext.request.contextPath }/review/${prdct.productId }">
						<div class="form-group p-2">
							<label for="review">Review</label> <input type="text"
								class="form-control" id="review" name="review"
								placeholder="Write your opinion about this product">

							<div class="form-row">
								<div class="col-auto my-1">
									<label class="mr-sm-2" for="rating">Rating</label> <select
										class="custom-select mr-sm-2" id="rating" name="rating">
										<option selected>Choose...</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>

				</div>

			</div>

		</div>



	</div>





	<script type="text/javascript">
		function fun1() {
			var x = document.getElementById("Review");
			var y = document.getElementById("Detail");

			x.style.display = "none";
			y.style.display = "block";

		}
		function fun2() {
			var x = document.getElementById("Review");
			var y = document.getElementById("Detail");

			y.style.display = "none";
			x.style.display = "block";

		}
	</script>
</body>

</html>
