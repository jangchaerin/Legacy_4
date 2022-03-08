/**
 * 
 */

const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');

checkAll.addEventListener("click", function(){
    for(c of check){
        c.checked=checkAll.checked;    
    }
})

//--------------------------
for(ch of check){
    ch.addEventListener("click",function(){

    let final=true;

    for(c of check){
        if(!c.checked){
            final=false;
         }
    } 
    checkAll.checked=final;
    })
}

//----------------------------
const btn=document.getElementById('btn');
btn.addEventListener("click", function(){

    if(checkAll.checked==true){
         location.href="./join";
    }else{
        alert("약관 동의 해주세요")
    }
})