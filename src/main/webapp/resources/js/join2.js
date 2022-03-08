//ID, PW, NAME, EMAIL, PHONE
const pw = document.getElementById('pw');
const pw2 = document.getElementById('pw2');
const pwResult=document.getElementById('pwResult');
const pwResult2=document.getElementById('pwResult2');
const id=document.getElementById('id');
const idResult=document.getElementById('idResult');
const name=document.getElementById('name');
const phone=document.getElementById('phone');
const email = document.getElementById('email');
const btn = document.getElementById('btn');
const frm = document.getElementById('frm');




//------------pw,pw2 같은지 비교-------------------
let pwcheck=true; //같지않으면 true, 같으면 false
pw2.addEventListener('blur',function(){
    let message='pw가 일치합니다'

    if(pw.value!=pw2.value){
       
        pwcheck=true;
         message='pw 일치하지 않습니다'
        pw2.value='';
      

    }else{
       
        pwcheck=false;
    } 
    pwResult2.innerHTML=message
})
//------------검증이 끝나고 pw를 수정했을 경우------
pw.addEventListener('change',function(){
    pwcheck=true;
    pw2.value='';
    pwResult.value='';
    pw2.focus();

})
//------------pw 길이 검증-------------------
pw.addEventListener('blur',function(){
    if(pw.value.length<8||pw.value.length>12){
        pwResult.innerHTML='pw 글자 수가 맞지 않습니다'
      

    }
})

//-------------id 입력 후 처리---------------
id.addEventListener('blur',function(){
    if(id.value==''){
        idResult.innerHTML='id를 입력하세요'
        
    }

})

//-------------가입버튼----------------------

btn.addEventListener('click',function(){
   if(id.value==''){
       alert('id를 입력하세요');
       id.focus();
       return;
   }
   if(pw.value==''|| pw.value.length<8||pw.value.length>12){
        alert('pw가 정확하지 않습니다');
        pw.focus();
        return;
    }
    if(pwcheck){
        alert('pw 일치하지 않습니다')
        pw2.focus();
        return;

    }
    if(name.value==''){
        alert('name를 입력하세요');
        name.focus();
        return;
    }
    if(phone.value==''){
        alert('phone를 입력하세요');
        phone.focus();
        return;
    }
    if(email.value==''){
        alert('email를 입력하세요');
        email.focus();
        return;
    }
    frm.submit();

})