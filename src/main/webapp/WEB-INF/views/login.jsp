<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>


<body>

	<div class="container">

		<div class="row ext-center mt-5">

			<div class="col">

				<!-- login -->
				<div id="login" class="card text-center col-md-6 offset-md-3">
					<div class="card-header bg-primary text-white">
						<h2>Login</h2>
					</div>
					<div class="card-body">
						<form action="checking" method="post">
							<div class="form-group">
								<label for="userId">UserId</label> <input type="text"
									class="form-control" id="userId" name="userId"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="userEmail">Email address</label> <input type="email"
									class="form-control" id="userEmail" name="userEmail"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							
							<div class="form-group">
								<label for="password">Password</label> <input
									type="password" class="form-control" id="password"
									name="password"
									placeholder="Password">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
						<p style="color: red;">user not found</p>
						
					</div>
					<div class="card-footer text-muted">
						<a onclick="showform1()" class="btn ">Or Register here </a>
					</div>
				</div>


				<!--  register -->

				<div id="register" class="card text-center col-md-6 offset-md-3"
					style="display: none">
					<div class="card-header bg-primary text-white">
						<h2>Register</h2>
					</div>
					<div class="card-body">
						<form action="creating" method="post">
						
						<div class="form-group">
								<label for="userId">UserId</label> <input type="text"
									class="form-control" id="userId" name="userId"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="userEmail">Email address</label> <input type="email"
									class="form-control" id="userEmail" name="userEmail"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							
							<div class="form-group">
								<label for="password">Password</label> <input
									type="password" class="form-control" id="password"
									name="password"
									placeholder="Password">
									<p style="color: red;">password should be greater than 8 characters</p>
							</div>
							

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
					<div class="card-footer text-muted">
						<a onclick="showform2()" class="btn ">Or login here </a>
					</div>
				</div>

			</div>

		</div>
	</div>




</body>

<script type="text/javascript">
	function showform1() {
		var x = document.getElementById("login");
		var y = document.getElementById("register");

		x.style.display = "none";
		y.style.display = "block";
	}

	function showform2() {
		var x = document.getElementById("login");
		var y = document.getElementById("register");

		x.style.display = "block";
		y.style.display = "none";
	}
</script>


</html>