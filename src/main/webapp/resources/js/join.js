/**
 * 
 */
const pwResult = document.getElementById('pwResult');
const pw = document.getElementById('pw');
const pw2=document.getElementById('pw2');
const pwResult2 = document.getElementById('pwResult2');

const id=document.getElementById('id');
const idResult = document.getElementById('idResult');

const frm=document.getElementById('frm');
const btn = document.getElementById('btn');

const name=document.getElementById('name');
const phone=document.getElementById('phone');
const email = document.getElementById('email');

let idcheck=false;    //전역변수
let pwcheck=false;   

let namecheck=false;
let phonecheck=false;
let emailcheck=false;

pw.addEventListener("change",function(){

    pwcheck=false;
    pw2.value='';
    pwResult2.innerHTML='';
    pw2.focus();
})
name.addEventListener('blur',function(){

    if(name.value==''){
        namecheck=false;
    }else{
        namecheck=true;
    }
})

phone.addEventListener('blur',function(){

    if(phone.value==''){
        phonecheck=false;
    }else{
        phonecheck=true;
    }
})
email.addEventListener('blur',function(){

    if(email.value==''){
        emailcheck=false;
    }else{
        emailcheck=true;
    }
})



pw.addEventListener("keyup",function(){
    let length=pw.value.length;
    let message="잘못된 비밀번호입니다 ";

    if(length>=8 && length<=12){
        message="올바른 비밀번호입니다 ";
    }

    pwResult.innerHTML=message;
    
})
pw2.addEventListener("blur",function(){
   
    let message="비밀번호가 일치하지 않습니다"

    if(pw.value==pw2.value){
        message="비밀번호가 일치합니다"
        pwcheck=true;
    }else{
         pwcheck=false;
    }
    pwResult2.innerHTML=message;


})
id.addEventListener("blur",function(){
   
    let v=id.value;

    if(v==''){
        idResult.innerHTML= 'id 필수';
        idcheck= false;
    }else{
        idcheck=true;
    }
})
btn.addEventListener("click", function(){

    if(idcheck&&pwcheck&&namecheck&&phonecheck&&emailcheck){
        frm.submit();
    }else{
        alert('필수요건을 확인하세요')
    }
})