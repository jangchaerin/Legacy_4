const title = document.getElementById('title')

const writer = document.getElementById('wirter')
const btn = document.getElementById('btn')
const frm=document.getElementById('frm');

let titlecheck=false;

let writercheck=false;

title.addEventListener('blur',function(){
    if(title.value==''){
        titlecheck=false;
    }else{
        titlecheck=true;
    }
})

writer.addEventListener('blur',function(){
    if(writer.value==''){
        writercheck=false;
    }else{
        writercheck=true;
    }
})

btn.addEventListener('click',function(){
    if(titlecheck && writercheck){
        frm.submit();
    }else{
        alert('제목, 작성자 필수요건')
    }

})