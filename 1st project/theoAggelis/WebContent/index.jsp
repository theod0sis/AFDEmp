<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>	
<%@ page session="true" %>
<!doctype html>
<html>
	<head>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Chios</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0 user-scalable=no">
		<meta name="theme-color" content="#e9300a">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
		<link rel="icon" type="image/ico" href="/theoAggelis/img/chioslogo.png" sizes="32x32">
		<link rel="stylesheet" href="/theoAggelis/css/main.css">
<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<% if ((String)session.getAttribute("email")==null){%>
	<nav class="navbar navbar-default navbar-fixed-top teo"  >
	  <div class="container-fluid">
	    <div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        	<span class="icon-bar"></span>
        	<span class="icon-bar"></span>
      	    <span class="icon-bar"></span>
      </button>
	      <a class="navbar-brand " href="#">
	      	<img class="brandimage" src="/theoAggelis/img/chioslogo.png" alt="Chios Travel Guide">
	      </a>
	    </div>
	    <div class="nav navbar-nav">
	    	<p class="headtitle">Chios Island</p>
	    </div>
	     <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#carousel">HOME</a></li>
        <li><a href="#login">SIGN IN</a></li>
        <li><a href="#contact">CONTACT</a></li>
        <li><a href="#googleMap">CHIOS</a></li>
      </ul>
          <form class="navbar-form navbar-right" role="form" action="loginServlet" method="post">
                    <div class="form-group">
                    <% if( (String) request.getAttribute("user")=="false") {%>
                        <a href="#" title="Wrong email or password" data-toggle="popover" data-placement="bottom" style="color:red;">Oups!</a>
                        <%} %>
                        <input type="email" name="email" placeholder="Email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <input type="password"  name="password" placeholder="Κωδικός" class="form-control" required>
                        
                    </div>
                    <button type="submit" class="btn btn-secondary">Είσοδος</button>
                </form>
            </div>
    </div>
	</nav>
	<%  }else{ %>
		<nav class="navbar navbar-default navbar-fixed-top teo"  >
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand " href="#">
	      	<img class="brandimage" src="/theoAggelis/img/chioslogo.png" alt="Chios Travel Guide">
	      </a>
	    </div>
	    <div class="nav navbar-nav">
	    	<p class="headtitle">Chios Island</p>
	    </div>
	     <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#carousel">HOME</a></li>
        <li><a href="#login">SIGN IN</a></li>
        <li><a href="#contact">CONTACT</a></li>
        <li><a href="#googleMap">CHIOS</a></li>
      </ul>
       
      <ul class="nav navbar-nav navbar-right">
       <li>
       <p class="headtitle">
         <% String s=(String)session.getAttribute("email"); out.println(s);%>
         </p>   
		</li>
		<li><button class="btn" id="logout"type="button" onclick="deleteSession()">LOGOUT</button></li>
	 
			</ul>	      
       </div>   
    </div>
	</nav>
	<% } %>
	<!-- Indicators -->
 <div id="carousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img class="caruselimg" src="/theoAggelis/img/chios6.jpg" alt="chios">
      <div class="carousel-caption">
      </div>
    </div>
    <div class="item">
      <img class="caruselimg" src="/theoAggelis/img/chios5.jpg" alt="chios">
      <div class="carousel-caption">
      </div>
    </div>
    <div class="item">
      <img class="caruselimg" src="/theoAggelis/img/volisos.jpeg" alt="chios">
      <div class="carousel-caption">
      </div>
    </div>
  </div>
  

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
	
		
	<div id="chios" class="container text-center">
  <h3>CHIOS</h3>
  <p><em>We love MASTIC!</em></p>
  <p>Much as Chios is famous for its mastic, it is not the only “magic” one can find on this island. Alongside its rich history starting from the Neolithic Age and including adventures with Saracene pirates and the Turks during the Greek Revolution, Chios also claims to be the birthplace of Homer. It was certainly the birthplace of eminent Greek politicians and writers such as Adamantios Korais, Emmanouil Roidis and Alexandre Mavrokordatos.</p>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <p class="text-center"><strong>Chios</strong></p><br>
      <a href="#demo" data-toggle="collapse">
        <img src="/theoAggelis/img/chios8.jpeg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo" class="collapse">
        <p>Chora, as it is known locally</p>
        <p>is the capital of the prefecture</p>
        <p>and has approximately 25.000 inhabitants</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>Anavatos</strong></p><br>
      <a href="#demo2" data-toggle="collapse">
        <img src="/theoAggelis/img/chios9.jpeg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo2" class="collapse">
        <p>The village was abandoned </p>
        <p>after the horrible slaughters of 1822 </p>
        <p>and in our days it is a national Monument for all the Chians and Greeks.</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>The island of Psara</strong></p><br>
      <a href="#demo3" data-toggle="collapse">
        <img src="/theoAggelis/img/chios10.jpeg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo3" class="collapse">
        <p>Psara is located 12 miles to the northwest.</p>
        <p>It can be reached by boat from the city of Chios</p>
        <p>or by a smaller motorboat from Limnia, the port of Volissos.</p>
      </div>
    </div>
  </div>
</div>


<div id="login" class="bg-1">
  <div class="container">
    <h3 class="text-center">Sign in <span id="here" ><b>HERE</b></span></h3>
   <div class="row text-center">
      <div class="col-sm-12">
    <div class="jumbotron">
    <span id="signin">
    	<h1>You love Chios?</h1>
    	<p>Help us with your Sign In!</p>
    </span>
    <button class="btn1" data-toggle="modal" data-target="#myModal">Sign In</button>
 	</div>
    </div>
 	 </div>
    </div>
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4><span class="glyphicon glyphicon-user"></span> Sign In</h4>
        </div>
        <div class="modal-body">
        
          <form role="form" action="regServlet" method="post">
            <div class="form-group">
              <label for="usrname"> Send To</label>
              <input type="email" name="email" class="form-control" onkeyup="showHint(this.value)" placeholder="Enter email" id="usrname"  required >
              <p id="val"></p>
            </div>
            <div class="form-group">
              <label for="usrname">Password</label>
              <input type="text" name="password"class="form-control" id="usrname" placeholder="Enter password" required >
            </div>
              <button type="submit"  class="btn btn-block" id="submint">Submit
                <span class="glyphicon glyphicon-ok"></span>
              </button>
          </form>
          
          
        </div>
        <div class="modal-footer">
          <p>Need <a href="#contact">help?</a></p>
        </div>
      </div>
    </div>
  </div>
</div>


<div id="contact" class="container">
  <h3 class="text-center">Contact</h3>
  <p class="text-center"><em>We love our fans!</em></p>

  <div class="row">
    <div class="col-md-4">
      <p>Fan? Drop a note.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>Chios, Greece</p>
      <p><span class="glyphicon glyphicon-phone"></span>Phone: +30 6944816378</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: welovechios@gmail.com</p>
    </div>
    <form action="commentServlet" method="post">
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comment" placeholder="Comment" rows="5"></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Send</button>
        </div>
      </div>
    </div>
    </form>
  </div>
  <br>
</div>


<div id="googleMap"></div>
<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>Creator Theodosis Aggelis. Find me 
  <a href="https://www.linkedin.com/in/theodosis-aggelis-65717073?trk=hp-identity-name" data-toggle="tooltip" title="Linkedin"><i class="fa fa-linkedin"></i></a>
  <a href="https://plus.google.com/u/0/+theodosisaggelis" data-toggle="tooltip" title="Googleplus"><i class="fa fa-fw fa-google-plus"></i></a>
  <a href="https://www.facebook.com/theodosis.aggelis" data-toggle="tooltip" title="Googleplus"><i class="fa fa-fw fa-facebook"></i></a>
  </p>
</footer>


<!-- Add Google Maps -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBGSoyBzTm7Sx9h7roGVdQyK_lezGr-r04&callback=initMap"></script>
<script>
var myCenter = new google.maps.LatLng(38.371323, 26.134773);

function initialize() {
var mapProp = {
center:myCenter,
zoom:10,
scrollwheel:false,
draggable:false,
mapTypeId:google.maps.MapTypeId.ROADMAP
};

var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker = new google.maps.Marker({
	position:myCenter,
	});
	
	marker.setMap(map);
	}

google.maps.event.addDomListener(window, 'load', initialize);
</script>

<!--wrong email popup  -->
<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();
});
</script>

<script>
function deleteSession() {
	var xhttp;
    if (confirm("Are you sure?") == true) {
    	xhttp = new XMLHttpRequest();
    	xhttp.open("GET", "deleteSession", true);
		xhttp.send();
    	location.reload(true);
    }
}

</script>

<!-- Ajax email check if exist -->
<script>
function showHint(str) {
  var xhttp;
  if (str.length == 0) {
    document.getElementById("val").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
	  if (xhttp.getResponseHeader("valid")=="false"){
      document.getElementById("val").innerHTML = "Email already exists!";
      document.getElementById("submint").setAttribute('disabled','disabled');
	  }else{
		  document.getElementById("val").innerHTML = "";
		  document.getElementById("submint").removeAttribute("disabled");;
	  }
  }
  xhttp.open("GET", "validateEmail?email="+str, true);
  xhttp.send();
}
</script>

</body>
</html>