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
							<a class="dropdown-item hovaravle"
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
	<!--  Navbar Ending -->

<c:set var="prdct" scope="session" value="${productId }"/>  

	<div class="container mt-3 border">

		<div class="row border">

			<div class="col border">
			
				<div class="card-header text-center">
					<h3>Customer Detail</h3>
				</div>

				<form action="	">
					<div class="row-flow">
						<div class="form-group">	
							<label for="inputEmail4">First Name</label> <input type="text"
								class="form-control" placeholder="First name">
						</div>	
						<div class="form-group">
							<label for="inputEmail4">Middel Name</label> <input type="text"
								class="form-control" placeholder="First name">
						</div>
						<div class="form-group">
							<label for="inputEmail4">Last Name</label> <input type="text"
								class="form-control" placeholder="Last name">
						</div>
						<div class="form-group">
							<label for="inputEmail4">Email</label> <input type="email"
								class="form-control" id="inputEmail4" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="inputAddress">Mobile 1</label> <input type="text"
								class="form-control" id="inputAddress"
								placeholder="0123456789">
						</div>	
						<div class="form-group">
							<label for="inputAddress">Mobile 2</label> <input type="text"
								class="form-control" id="inputAddress"
								placeholder="0123456789">
						</div>					

						<div class="form-group">
							<label for="inputCity">City</label> <input type="text"
								class="form-control" id="inputCity">
						</div>
						
						<div class="form-group">
							<label for="inputCity">State</label> <input type="text"
								class="form-control" id="inputCity">
						</div>
						<div class="form-group">
							<label for="inputCity">Country</label> <input type="text"
								class="form-control" id="inputCity">
						</div>
												
						<div class="form-group">
							<label for="inputZip">PIN</label> <input type="text"
								class="form-control" id="inputZip">
						</div>						
					</div>
					
					  <button class="btn btn-primary" type="submit">Go for Pay</button>
					  
				</form>
				 <a href="${pageContext.request.contextPath }/productdetail/${prdct }" class="btn btn-primary text-white" >Back</a>

			</div>
		</div>
	</div>



</body>

</html>