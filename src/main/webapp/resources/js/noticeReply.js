const reply = document.querySelector("#reply");
const num = document.querySelector("#num");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const replyResult = document.querySelector("#replyResult");

result();

function result(){
    const xhttp=new XMLHttpRequest();
    xhttp.open("GET","../noticeReply/list")
    xhttp.send();
}

reply.addEventListener("click", function(){
    //console에 num, writer, contents 출력
    console.log(num.value);
    console.log(writer.value);
    console.log(contents.value);

    //js에서 요청 객체 생성
    const xhttp=new XMLHttpRequest();

    //요청 정보입력
    xhttp.open("POST","../noticeReply/add");

    //요청 header 정보
    xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    //요청 전송
    //post 요청 시 파라미터
    //send("이름 =값&이름2=값2...")
    xhttp.send("num="+num.value+"&writer="+writer.value+"&contents="+contents.value);

    //응답처리
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText);
            let result = this.responseText.trim();
            if (result=='1'){
                alert("댓글이 등록되었습니다.");
            }else{
                alert("댓글 등록에 실패했습니다.");
            }
        }

    }

});