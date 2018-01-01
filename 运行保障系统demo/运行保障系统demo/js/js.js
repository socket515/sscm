function jumpto(pagename) {
window.location.href=pagename;
}

function jumptotarget(pagename,target) {
window.open(pagename,target,"");
}

function CheckAll(form)  {
  for (var i=0;i<form.elements.length;i++)    {
    var e = form.elements[i];
    if (e.name != 'checkbox')       e.checked = form.checkbox.checked; 
   }
  }

// Example: obj = findObj("image1");

function findObj(theObj, theDoc)

{

  var p, i, foundObj;

  

  if(!theDoc) theDoc = document;

  if( (p = theObj.indexOf("?")) > 0 && parent.frames.length)

  {

    theDoc = parent.frames[theObj.substring(p+1)].document;

    theObj = theObj.substring(0,p);

  }

  if(!(foundObj = theDoc[theObj]) && theDoc.all) foundObj = theDoc.all[theObj];

  for (i=0; !foundObj && i < theDoc.forms.length; i++) 

    foundObj = theDoc.forms[i][theObj];

  for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++) 

    foundObj = findObj(theObj,theDoc.layers[i].document);

  if(!foundObj && document.getElementById) foundObj = document.getElementById(theObj);

  

  return foundObj;

}
function resetData() {
            document.loginF.reset();
        }
		function MM_preloadImages() { //v3.0
            var d = document;
            if (d.images) {
                if (!d.MM_p) d.MM_p = new Array();
                var i,j = d.MM_p.length,a = MM_preloadImages.arguments;
                for (i = 0; i < a.length; i++)
                    if (a[i].indexOf("#") != 0) {
                        d.MM_p[j] = new Image;
                        d.MM_p[j++].src = a[i];
                    }
            }
        }

        function MM_swapImgRestore() { //v3.0
            var i,x,a = document.MM_sr;
            for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) x.src = x.oSrc;
        }

        function MM_findObj(n, d) { //v4.01
            var p,i,x;
            if (!d) d = document;
            if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
                d = parent.frames[n.substring(p + 1)].document;
                n = n.substring(0, p);
            }
            if (!(x = d[n]) && d.all) x = d.all[n];
            for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
            for (i = 0; !x && d.layers && i < d.layers.length; i++) x = MM_findObj(n, d.layers[i].document);
            if (!x && d.getElementById) x = d.getElementById(n);
            return x;
        }

        function MM_swapImage() { //v3.0
            var i,j = 0,x,a = MM_swapImage.arguments;
            document.MM_sr = new Array;
            for (i = 0; i < (a.length - 2); i += 3)
                if ((x = MM_findObj(a[i])) != null) {
                    document.MM_sr[j++] = x;
                    if (!x.oSrc) x.oSrc = x.src;
                    x.src = a[i + 2];
                }
        }

        function sub() {
            document.loginF.action = "<c:url value='login.do?command=LoginSys'/>";
            document.loginF.submit();
        }

        function resetData() {
            document.loginF.reset();
        }

        function AsaiKeyJs(){
            if(event.keyCode == 13){sub();}
        }
	
function changelocation(locationid){
	subcat = new Array();
	subcat[0] = new Array("暂时停电保障","1","1");
	subcat[1] = new Array("电话号码新增","1","2");
	subcat[2] = new Array("保险柜维护","2","3");
	subcat[3] = new Array("办公桌椅维护","2","4");
	subcat[4] = new Array("主机故障","3","5");
	subcat[5] = new Array("一体机维护","3","6");

    document.myform.smalllocation.length = 0; 
    for (var i=0;i < 6; i++)
        {
            if (subcat[i][1] == locationid)
            { 
            document.myform.smalllocation.options[document.myform.smalllocation.length] = new Option(subcat[i][0], subcat[i][2]);
            }        
        }   
}
function showorhid(typeneme){
	if(typeneme=="services"){
		document.getElementById("item").style.display="none";
		document.getElementById("services").style.display="block";
	}else if(typeneme=="item"){
		document.getElementById("services").style.display="none";
		document.getElementById("item").style.display="block";
	}
}
function showpass(){
	if(document.getElementById("xgmm").style.display=="none"){
		document.getElementById("xgmm").style.display="block"
	}else if(document.getElementById("xgmm").style.display=="block"){
		document.getElementById("xgmm").style.display="none"
	}
}
function changebg(obj,type){
  	if(type=="1"){
		if(obj.className=="btnover"){
			obj.className="btn";
		}else if(obj.className =="btn"){
			obj.className="btnover";
		}
	}else if(type=="2"){
		if(obj.className=="btnover2"){
			obj.className="btn2";
		}else if(obj.className =="btn2"){
			obj.className="btnover2";
		}
	}
}

		
