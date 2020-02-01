function PwdCheck() {
    var pwd1 = document.getElementById("pwd").value;
    var pwd2 = document.getElementById("pwd2").value;
    if(pwd1 == pwd2) {
        document.getElementById("tip").innerHTML="<span style='color: green; '>两次密码相同</span>";
        document.getElementsByClassName("submit").disabled = false;
    }
    else {
        document.getElementById("tip").innerHTML="<span style='color: red; '>两次密码不相同</span>";
      document.getElementsByClassName("submit").disabled = true;
    }
}
function NameCheck(){
    var uname = document.getElementById("username").value;
    var chPattern = /^[a-zA-Z0-9_]{6,18}$/;
    if(!chPattern.exec(uname))
    {
        document.getElementById("nametip").innerHTML="<span style='color: red; '>用户名不合法</span>"
    } else
    {
        document.getElementById("nametip").innerHTML="<span style='color: green; '>用户名合法</span>"
    }
}

function Dynam() {

    $('#navigation a').stop().animate({'marginLeft':'-85px'},1000);
   
    $('#navigation > li').hover(
     function () {
      $('a',$(this)).stop().animate({'marginLeft':'-2px'},200);
     },
     function () {
      $('a',$(this)).stop().animate({'marginLeft':'-85px'},200);
     }
    );
   }
   function displayTime() {
    document.getElementById("time").innerHTML = new Date().toTimeString();
} 
      

   window.onload=function(){
       Dynam();
       setInterval(displayTime,1000);      // 每隔1秒钟调用displayTime函数
   }