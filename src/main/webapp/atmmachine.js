function callApi(METHOD,URL,DATA,SUCCESS)
{
	 var xhttp=new XMLHttpRequest();
	 xhttp.open(METHOD,URL,true);
	 xhttp.setRequestHeader('Content-Type','application/json');
	 xhttp.onreadystatechange=function()
	 {
	 	if(this.readyState == 4)
	  	{
		   	if(this.status == 200)
		    	SUCCESS(this.responseText);
		   	else
		    	alert("404: Service unavailable"); 
		}
		  
	 };
	 xhttp.send(DATA);
}
function getbalance()
{
var url;
 if(d1.value=="sbi")
 url="http://localhost:8081/atm/fromsbi/"+t1.value;
 else
  url="http://localhost:8081/atm/fromunion/"+t1.value;
callApi("GET",url,"",getResponse);
}
function getResponse(res)
{
var data=JSON.parse(res);
alert("Available balance Amount is:"+data.balance);
}