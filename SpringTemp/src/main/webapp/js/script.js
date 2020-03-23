function writeSave() {
	if (document.writeForm.writer.value == "") {
		alert('작성자를 입력해 주세요.');
		document.writeForm.writer.focus();
		return false;
	}

	if (document.writeForm.email.value == "") {
		alert('이메일을 입력해 주세요.');
		document.writeForm.email.focus();
		return false;
	}

	if (document.writeForm.subject.value == "") {
		alert('제목을 입력해 주세요');
		document.writeForm.subject.focus();
		return false;
	}

	if (document.writeForm.content.value == "") {
		alert('내용을 입력해 주세요.');
		document.writeForm.content.focus();
		return false;
	}

	if (document.writeForm.pass.value == "") {
		alert('비밀번호를 입력해 주세요.');
		document.writeForm.pass.focus();
		return false;
	}

}

function deleteSave() {

	if (document.delForm.pass.value == "") {
		alert('비밀번호를 입력해주세요.');
		document.delForm.pass.focus();
		return false;
	}

}
function idCheck(id) {
	if (id == "") {
		alert("아이디를 입력 해주세요.");
		document.regForm.id.focus();
	} else {
		url = "../membercontrol/IdCheckCon.do?idCheck&id=" + id;
		window.open(url, "post", "width=350,height=230");
	}
}

function zipCheck() {
	url = "../membercontrol/ZipCheckCon.do?zipCheck&check=y";
	window.open(url, "post", "toobar=no, width=550, height=300, " +
			"directories=no, status=yes, scrollbars=yes, menubar=no");
}

function dongCheck() {
	if (document.zipForm.dong.value == "") {
		alert("동 이름을 입력하세요.");
		document.zipForm.dong.focus();
		return;
	}
	document.zipForm.submit();
}

function sendAddress(zipcode,sido,gugun,dong,ri,bunji) {
	var address = sido + " " + gugun + " " + dong + " " + ri + " " + bunji;
	opener.document.regform.zipcode.value = zipcode;
	opener.document.regform.address1.value = address;
	self.close();
}

//입력 데이터의 유효성 검사
function inputCheck() {
	if (document.regForm.id.value == "") {
		alert("아이디를 입력해주세요")
		document.regForm.id.focus();
		return;
	}

	if (document.regForm.pass.value == "") {
		alert("비밀번호를 입력해주세요")
		document.regForm.pass.focus();
		return;
	}

	if (document.regForm.repass.value != document.regForm.pass.value) {
		alert("비밀번호가 일치하지 않습니다 ")
		document.regForm.repass.focus();
		return;
	}

	if (document.regForm.name.value == "") {
		alert("이름을 입력해주세요")
		document.regForm.name.focus();
		return;
	}

	if (document.regForm.phone2.value == "") {
		alert("전화번호를 입력해주세요")
		document.regForm.phone2.focus();
		return;
	}

	if (document.regForm.phone3.value == "") {
		alert("전화번호를 입력해주세요2")
		document.regForm.phone3.focus();
		return;
	}

	if (document.regForm.email.value == "") {
		alert("이메일을 입력해주세요")
		document.regForm.email.focus();
		return;
	}

	var str = document.regForm.email.value;
	//이메일 형식검사
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;

	if (atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1
			&& commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize)
		;
	else {
		alert("Email 주소 형식이 잘못 되었습니다.\n\r 다시 입력해 주세요");
		document.regForm.email.focus();
		return;
	}

	if (document.regForm.zipcode.value == "") {
		alert("우편번호를 입력해주세요")
		document.regForm.zipcode.focus();
		return;
	}

	if (document.regForm.address1.value == "") {
		alert("주소을 입력해주세요")
		document.regForm.address1.focus();
		return;
	}

	if (document.regForm.address2.value == "") {
		alert("상세한주소를 입력해주세요")
		document.regForm.address2.focus();
		return;
	}

	document.regForm.submit();
}

function updateCheck() {

	if (document.regForm.pass.value == "") {
		alert("비밀번호를 입력해주세요")
		document.regForm.pass.focus();
		return;
	}

	if (document.regForm.repass.value != document.regForm.pass.value) {
		alert("비밀번호가 일치하지 않습니다 ")
		document.regForm.repass.focus();
		return;
	}

	if (document.regForm.name.value == "") {
		alert("이름을 입력해주세요")
		document.regForm.name.focus();
		return;
	}

	if (document.regForm.phone2.value == "") {
		alert("전화번호를 입력해주세요")
		document.regForm.phone2.focus();
		return;
	}

	if (document.regForm.phone3.value == "") {
		alert("전화번호를 입력해주세요2")
		document.regForm.phone3.focus();
		return;
	}

	if (document.regForm.email.value == "") {
		alert("이메일을 입력해주세요")
		document.regForm.email.focus();
		return;
	}

	var str = document.regForm.email.value;
	//이메일 형식검사
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;

	if (atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1
			&& commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize)
		;
	else {
		alert("Email 주소 형식이 잘못 되었습니다.\n\r 다시 입력해 주세요");
		document.regForm.email.focus();
		return;
	}

	if (document.regForm.zipcode.value == "") {
		alert("우편번호를 입력해주세요")
		document.regForm.zipcode.focus();
		return;
	}

	if (document.regForm.address1.value == "") {
		alert("주소을 입력해주세요")
		document.regForm.address1.focus();
		return;
	}

	if (document.regForm.address2.value == "") {
		alert("상세한 주소를 입력해주세요")
		document.regForm.address2.focus();
		return;
	}

	document.regForm.submit();
}

function begin() {
	document.myForm.pass.focus();
}

function checkIt() {

	if (!document.myForm.pass.value) {
		alert('비밀번호가 입력되지 않았습니다.')
		document.myForm.pass.focus();
		return false;
	}
}

var commentRequest = new XMLHttpRequest(); //ajax를 쓰기 위해 인스턴스 생성

function commentFunction(){
	commentRequest.open("Post","../BoardCommentServlet?commentWriter="+encodeURIComponent(document.getElementById("loginID").value) +
								"&PaNum=" + encodeURIComponent(document.getElementById("PaNum").value)+
								"&commentContent="+encodeURIComponent(document.getElementById("commentContent").value), true);
	commentRequest.onreadystatechange = commentProcess;
	commentRequest.send(null);
}
function commentProcess(){
    if(commentRequest.readyState == 4 && commentRequest.status == 200){    //성공적으로 통신이 된다면 
        
    	var result = commentRequest.responseText;
    	if(result != 1){
    		alert('작성 실패');
    	}
    	else{
        	 var commentContent = document.getElementById("commentContent");
        	
        	 commentContent.value = "";
        	 commentSearchFunction();

    	}    
    	}
        
}
var commentsearchRequest = new XMLHttpRequest();

function commentSearchFunction(){
	commentsearchRequest.open("Post","../BoardCommentSearchServlet?comment="+encodeURIComponent(document.getElementById("commentsearch").value)+
							  "&PaNum=" + encodeURIComponent(document.getElementById("PaNum").value), true);
	commentsearchRequest.onreadystatechange = commentSearchProcess;
	commentsearchRequest.send(null);
}
function commentSearchProcess(){
    var table = document.getElementById("commentTable"); //html에 ajaxTable이라는 아이디를 갖는 tbody를 가져옴
    table.innerHTML =""; //빈공간으로 초기화
    if(commentsearchRequest.readyState == 4 && commentsearchRequest.status == 200){    //성공적으로 통신이 된다면 
        var object = eval('('+commentsearchRequest.responseText+')');
        var result = object.result;        //servlet에서 배열을 담는 result를 받아옴 
        for(var i=0; i<result.length; i++){        //넘어온 result의 길이까지 반복
            var row = table.insertRow(0);         //테이블에 행을 추가
            for(var j=0; j<result[i].length; j++){    //result 배열에는 comment 내용들이  들어있으므로 하나씩 접근
                var cell = row.insertCell(j);    //위에서 만들어진 행에 하나의 셀을 추가
                cell.innerHTML=result[i][j].value;    //innerHTML에 값을 표시
            }
        }
    }
   
}


var likeRequest = new XMLHttpRequest();

function likesFunction(){
	likeRequest.open("Post","../BoardLikeServlet?likes="+encodeURIComponent(document.getElementById("good").value)+
						"&PaNum="+encodeURIComponent(document.getElementById("PaNum").value)+
						"&loginID="+encodeURIComponent(document.getElementById("loginID").value),true)
	likeRequest.onreadystatechange = likesProcess;
	likeRequest.send(null);
}
function likesProcess(){
	if(likeRequest.readyState == 4 && likeRequest.status == 200){
		var result = likeRequest.responseText;
		if(result == 1){
			alert('추천되었습니다!');
		}else if(result == 0){
			alert('이미 추천되었습니다.');
		}else if(result == -1){
			alert('로그인 후 사용해주세요');
		}
	}
}

var hateRequest = new XMLHttpRequest();

function hatesFunction(){
	hateRequest.open("Post","../BoardHateServlet?hates="+encodeURIComponent(document.getElementById("bad").value)+
						"&PaNum="+encodeURIComponent(document.getElementById("PaNum").value)+
						"&loginID="+encodeURIComponent(document.getElementById("loginID").value),true)
	hateRequest.onreadystatechange = hatesProcess;
	hateRequest.send(null);
}
function hatesProcess(){
	if(hateRequest.readyState == 4 && hateRequest.status == 200){
		var result = hateRequest.responseText;
		if(result == 1){
			alert('반대되었습니다!');
		}else if(result == 0){
			alert('이미 반대하였습니다.');
		}else if(result == -1){
			alert('로그인 후 사용해주세요');
		}
	}
}
var scrapRequest = new XMLHttpRequest();
function scrapFunction(){
	scrapRequest.open("Post","../BoardScrapServlet?scrap="+encodeURIComponent(document.getElementById("scrap").value)+
						"&PaNum="+encodeURIComponent(document.getElementById("PaNum").value)+
						"&loginID="+encodeURIComponent(document.getElementById("loginID").value)+
						"&pageNum="+encodeURIComponent(document.getElementById("pageNum").value), true)
	scrapRequest.onreadystatechange = scrapProcess;
	scrapRequest.send(null);
}
function scrapProcess(){
	if(scrapRequest.readyState == 4 && scrapRequest.status == 200){
		var result = scrapRequest.responseText;
		if(result == 1){
			alert('스크랩하였습니다.');
		}else if(result == 0){
			alert('이미 스크랩 하였습니다.')
		}
		else if(result == -1){
			alert('스크랩 실패');
		}
	}
}

var deleteRequest = new XMLHttpRequest();
function deleteFunction(){
	deleteRequest.open("Post","../ScrapDeleteServlet?PaNum="+encodeURIComponent(document.getElementById("PaNum").value)+
						"&loginID="+encodeURIComponent(document.getElementById("loginID").value), true)
	deleteRequest.onreadystatechange = deleteProcess;
	deleteRequest.send(null);
}
function deleteProcess(){
	if(deleteRequest.readyState == 4 && deleteRequest.status == 200){
		var result = deleteRequest.responseText;
		if(result == 1){
			alert('삭제하였습니다.')
		}else{
			alert('삭제 실패')
		}
	}
}


 
