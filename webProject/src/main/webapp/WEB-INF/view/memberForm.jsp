<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Register - SB Admin</title>
  <link href="css/adm_styles.css" rel="stylesheet" />
  <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="bg-primary">
  <div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
      <main>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-7">
              <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header">
                  <h3 class="text-center font-weight-light my-4">Create Account</h3>
                </div>
                <div class="card-body">
                  <form action="addMember.do" method="get" name="addFrm">
                    <div class="row mb-3">
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input class="form-control" id="inputFirstName" type="text" placeholder="Enter your ID"
                            name="mid" />
                          <label for="inputFirstName">ID</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-floating">
                          <input class="form-control" id="inputLastName" type="text" placeholder="Enter your Name"
                            name="mname" />
                          <label for="inputLastName">Name</label>
                        </div>
                      </div>
                    </div>
                    <div class="form-floating mb-3">
                      <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com"
                        name="phone" />
                      <label for="inputEmail">Phone</label>
                    </div>
                    <div class="row mb-3">
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input class="form-control" id="inputPassword" type="password" placeholder="Create a password"
                            name="pw" />
                          <label for="inputPassword">Password</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input class="form-control" id="inputPasswordConfirm" type="password"
                            placeholder="Confirm password" />
                          <label for="inputPasswordConfirm">Confirm Password</label>
                        </div>
                      </div>
                    </div>
                    <div class="mt-4 mb-0">
                      <div class="d-grid"><a class="btn btn-primary btn-block" href="login.do">Create Account</a></div>
                    </div>
                  </form>
                </div>
                <div class="card-footer text-center py-3">
                  <div class="small"><a href="loginForm.do">Have an account? Go to login</a></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
    <div id="layoutAuthentication_footer">
      <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid px-4">
          <div class="d-flex align-items-center justify-content-between small">
            <div class="text-muted">Copyright &copy; Your Website 2023</div>
            <div>
              <a href="#">Privacy Policy</a>
              &middot;
              <a href="#">Terms &amp; Conditions</a>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous">
  </script>
  <script src="js/adm_scripts.js"></script>
  <script>
    document.querySelector('a[href="login.do"]').addEventListener('click', function (e) {
      e.preventDefault();
      const id = document.querySelector('#inputPassword').value;
      const id2 = document.querySelector('#inputPasswordConfirm').value;
      if (id != id2) {
        alert("비번을 확인하세요!!");
        document.querySelector('#inputPassword').value = "";
        document.querySelector('#inputPasswordConfirm').value = "";
        return;
      }
      document.querySelector('form[name="addFrm"]').submit();
    })
  </script>
</body>

</html>