<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<style>



/* <script> */
/* function goBack() { */
/*     window.history.back(); */
/* } */
/* </script> */



body{
    background: -webkit-linear-gradient(left, #0000, #00c6ff);
}
.emp-profile{
    padding: 3%;
    margin-top: 3%;
    margin-bottom: 3%;
    border-radius: 0.5rem;
    background: #fff;
}
.profile-img{
    text-align: center;
}
.profile-img img{
    width: 40%;
    height: 50%;
}
.profile-img .file {
    position: relative;
    overflow: hidden;
    margin-top: -20%;
    width: 70%;
    border: none;
    border-radius: 0;
    font-size: 15px;
    background: #212529b8;
}
.profile-img .file input {
    position: absolute;
    opacity: 0;
    right: 0;
    top: 0;
}
.profile-head h5{
    color: #333;
}
.profile-head h6{
    color: #0062cc;
}
.profile-edit-btn{
    border: none;
    border-radius: 1.5rem;
    width: 70%;
    padding: 2%;
    font-weight: 600;
    color: #6c757d;
    cursor: pointer;
}
.proile-rating{
    font-size: 12px;
    color: #818182;
    margin-top: 5%;
}
.proile-rating span{
    color: #495057;
    font-size: 15px;
    font-weight: 600;
}
.profile-head .nav-tabs{
    margin-bottom:5%;
}
.profile-head .nav-tabs .nav-link{
    font-weight:600;
    border: none;
}
.profile-head .nav-tabs .nav-link.active{
    border: none;
    border-bottom:0px solid #0062cc;
}
.profile-work{
    padding: 14%;
    margin-top: -15%;
}
.profile-work p{
    font-size: 12px;
    color: #818182;
    font-weight: 600;
    margin-top: 10%;
}
.profile-work a{
    text-decoration: none;
    color: #495057;
    font-weight: 600;
    font-size: 14px;
}
.profile-work ul{
    list-style: none;
}
.profile-tab label{
    font-weight: 600;
}
.profile-tab p{
    font-weight: 600;
    color: #0062cc;
}</style>



</head>
<body>

<%@ include file="navbar1.jsp"%>


 <br><br><br><br><br><br>
             
 
 
<div class="row">

    <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="<c:url value="/resource/images/favicon1.png"/>" alt=""/>
<!--                             <div class="file btn btn-lg btn-primary"> -->
<!--                                 Change Photo -->
<!--                                 <input type="file" name="file"/> -->
<!--                             </div> -->
                        </div>
                    </div>

            <form method="post">
<!--                 <div class="row"> -->
<!--                     <div class="col-md-4"> -->
<!--                         <div class="profile-img"> -->
<!--                             <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/> -->
<!--                             <div class="file btn btn-lg btn-primary"> -->
<!--                                 Change Photo -->
<!--                                 <input type="file" name="file"/> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!-- <!--                     <div class="col-md-6"> --> 
<!-- <!--                         <div class="profile-head"> --> 
<!-- <!--                                     <h5> --> 
<!-- <!--                                         User Information --> 
<!-- <!--                                     </h5> --> 
<!-- <!--                                     <h6> --> 

<!-- <!--                                     </h6> --> 
                                    
<!-- <!--                             <ul class="nav nav-tabs" id="myTab" role="tablist"> --> 
<!-- <!--                                 <li class="nav-item"> --> 
<!-- <!--                                     <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">ClickHere</a> --> 
<!-- <!--                                 </li> --> 
<!-- <!--                                 <li class="nav-item"> --> 
<!-- <!--                                     <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a> --> 
<!-- <!--                                 </li> --> 
<!-- <!--                             </ul> --> 
<!-- <!--                         </div> --> 
<!-- <!--                     </div> --> 
<!-- <!--                     <div class="col-md-2"> --> 
<!-- <!--                         <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/> --> 
<!-- <!--                     </div> --> 
<!--                 </div> -->








                <div class="row">
                    <div class="col-md-4">

                    </div>
                    <div class="col-md-8">
                        <div >
                            <div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>FirstName:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.firstName}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>PhoneNo:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.customerPhone}</p>
                                            </div><br>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>EmailId:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.users.emailId}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Shipping Address:</label>
                                            </div>
<!--                                              <div class="col-md-6"> -->
<!--                                                 <label>address:</label> -->
<!--                                             </div> -->
                                            <div class="col-md-6">
                                                <p>${customer.shippingAddress.address}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>city:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.shippingAddress.city}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>state:</label>
                                            </div>
                                             <div class="col-md-6">
                                                <p>${customer.shippingAddress.state}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>zipcode:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.shippingAddress.zipcode}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>country:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.shippingAddress.country}</p>
                                            </div><br>
                                        </div>
                                        
                                        <br><br>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>BillingAddress:</label>
                                            </div>
<!--                                              <div class="col-md-6"> -->
<!--                                                 <label>address:</label> -->
<!--                                             </div> -->
                                            <div class="col-md-6">
                                                <p>${customer.billingAddress.address}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>city:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.billingAddress.city}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>state:</label>
                                            </div>
                                             <div class="col-md-6">
                                                <p>${customer.billingAddress.state}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>zipcode:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.billingAddress.zipcode}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <label>country:</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${customer.billingAddress.country}</p>
                                            </div><br>
                                        </div>
                                        
                                        
                                        
                                        <div class="row">
<!--                                             <div class="col-md-6"> -->
<!--                                                 <label>Country:</label> -->
<!--                                             </div> -->
                                            <div class="col-md-6">
                                                <p>  </p>
                                            </div><br>
                                        </div>
                            </div>
<!--                             <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab"> -->
<!--                                         <div class="row"> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <label>Name:</label> -->
<!--                                             </div> -->
<!--                                             <div class="col-md-6"> -->
<%--                                                 <p>${currentUser}</p> --%>
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                         <div class="row"> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <label>Hourly Rate</label> -->
<!--                                             </div> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <p>10$/hr</p> -->
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                         <div class="row"> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <label>Total Projects</label> -->
<!--                                             </div> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <p>230</p> -->
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                         <div class="row"> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <label>English Level</label> -->
<!--                                             </div> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <p>Expert</p> -->
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                         <div class="row"> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <label>Availability</label> -->
<!--                                             </div> -->
<!--                                             <div class="col-md-6"> -->
<!--                                                 <p>6 months</p> -->
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-12"> -->
<!--                                         <label>Your Bio</label><br/> -->
<!--                                         <p>Your detail description</p> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </div> -->
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="index1">Go Back </a>  
           </div>   <br><br>
                    </div>
                </div>
            </form>           
        </div>
        </div>
        </body>
</html> 
