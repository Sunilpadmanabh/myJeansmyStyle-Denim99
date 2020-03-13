<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="page-login-form box">
           <h3>
           Create New Password
           </h3>
           <form:form role="form" id="depListForm" class="login-form"  method="post">
             <p class="Error">${Success}</p>
             <p class="Error1">${failed}</p>
              <input type="hidden" id="userId" name="userId" />
             <div class="form-group">
               <div class="input-icon">
                 <i class="icon fa fa-user"></i>
                 <input type="text" id="sender-username" class="form-control" name="email"
                   value="${userList.email}" placeholder="Registered Email">
               </div>
             </div>  
              <div class="form-group">
               <div class="input-icon" id="myPassword">
                 <i class="icon fa fa-unlock-alt"></i>
                 <input type="password" id="sender-username" class="form-control" id="txtPassword"
                 name="userPassword" maxlength="15"pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must 
                 contain at least one number and one uppercase and lowercase letter, and at least 8 or more 
                 characters" placeholder="New Password" required>
                 <input type="text" class="form-control" id="txthdnPassword" placeholder="New Password"/>
               </div>
               <div class="checkbox">
                    <input type="checkbox" id="remember" name="rememberme" value="forever" style="float: left;">
                    <label for="remember">Show Password</label>
                     <p class="Error1">${failed1}</p>
              </div>
             </div>                   
             <button class="btn btn-common log-btn"
             onclick="javascript:changePassword(${userList.userId});">Change</button>
           </form:form>
         </div>
       <script type="text/javascript">function changePassword(userId){
     document.getElementById('userId').value=userId;
         document.getElementById('depListForm').action="saveNewPassword";
         document.getElementById('depListForm').submit();
     } 
     </script>
     


</body>
</html>