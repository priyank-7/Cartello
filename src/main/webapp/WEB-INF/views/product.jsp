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
							<a class="dropdown-item hovaravle" href="${pageContext.request.contextPath }/products/${cat.getId() }">${cat.categoryName }</a>
						</c:forEach>

					</div></li>
				<li class="nav-item border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/">Home <i
						class="fa-solid fa-house fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/cart">Cart <i
						class="fa-solid fa-cart-shopping fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/wishlist">Wish List <i class="fa-solid fa-heart fa-beat fa-lg"
						style="color: #2756c4;"></i></a></li>
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
	<!--  Navbar Ending -->


<c:set var="prdct" scope="session" value="${product }"/>  
<c:set var="categor" scope="session" value="${pathCat }"/>  

	<div class="container-fluid">
		<div class="row mt-2">
			<div class="container-fluid col-md-2">
				<div class="row text-center justify-content-center">
					<div class="card col-md-12 pl-1 pr-1 align-item-center text-center justify-content-center" style="border: none">
						<div class="card-header">Filters</div>
						
						<div class="card-body">
							<table class="table text-center align-item-center border"> 
								
								<thead class="thead-light">
									<tr>
										<th scope="col">Price</th>
									</tr>
								</thead>								

								<tbody>
									<tr class="btn-dark">
										<td><a
											href="${pageContext.request.contextPath }/filter/${1000 }/${categor }">A to Z</a></td>
									</tr>
								</tbody>

								<tbody>
									<tr class="btn-dark">
										<td><a
											href="${pageContext.request.contextPath }/filter/${3000 }/${categor }">Z to A</a></td>
									</tr>
								</tbody>							

							</table>
						</div>
						
						
						<div class="card-body">
							<table class="table text-center align-item-center border"> 
								
								<thead class="thead-light">
									<tr>
										<th scope="col">Price</th>
									</tr>
								</thead>								
								<tbody>
									<tr class="btn-dark">
										<td><a
											href="${pageContext.request.contextPath }/filter/0/${categor }">All</a></td>
									</tr>
								</tbody>
								<tbody>
									<tr class="btn-dark">
										<td><a
											href="${pageContext.request.contextPath }/filter/${1000 }/${categor }">Less than 1000</a></td>
									</tr>
								</tbody>

								<tbody>
									<tr class="btn-dark">
										<td><a
											href="${pageContext.request.contextPath }/filter/${3000 }/${categor }">Less than 3000</a></td>
									</tr>
								</tbody>

								<tbody> 
									<tr class="btn-dark">
										<td><a
											href="${pageContext.request.contextPath }/filter/${5000 }/${categor }">Less than 5000</a></td>
									</tr>
								</tbody>

								<tbody>
									<tr class="btn-dark">
										<td><a
											href="${pageContext.request.contextPath }/filter/${10000 }/${categor }">Less than 10000</a></td>
									</tr>
								</tbody>

							</table>
						</div>
											
					</div>
				</div>
			</div>




			<div class="container-fluid col-md-10">
				<div class="row mt-1 justify-content-center text-center">

					<c:forEach items="${product }" var="product">					
						<div class="card col-md-3 mt-3 hovaravle bg-dark text-white ml-1 p-2" style="border: none">
							<img class="card-img-top" src="${product.imageUrl }"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">${product.productName }</h5>
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
							</div>
							<div class="card-footer"
								style="border-top: none; border-bottom: 1px solid rgba(0, 0, 0, .125)">
																
									<a class="col-md-4 col-sm-2" href="${pageContext.request.contextPath }/productdetail/${product.productId }"><i class="fa-solid fa-circle-info fa-xl" style="color: #2564d0;"></i></a>							
									<a class="col-md-4 col-sm-2" href="${pageContext.request.contextPath }/addtolist/${product.productId }"><i class="fa-solid fa-heart fa-xl" style="color: #e010d9;"></i></a>							
									<a class="col-md-4 col-sm-2" href="${pageContext.request.contextPath }/addtocart/${product.productId }"><i class="fa-solid fa-cart-shopping fa-xl" style="color: #26c939;"></i></a>												
							</div>
						</div>				
					</c:forEach>

				</div>

			</div>
		</div>
	</div>




</body>

</html>