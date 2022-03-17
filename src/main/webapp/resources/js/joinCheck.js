/**
 * 
 */

const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');
const rules = document.getElementById('rules');
const btn=document.getElementById('btn');

checkAll.addEventListener("click", function(){
    for(c of check){
        c.checked=checkAll.checked;    
    }
})
//--------------------------
rules.addEventListener("click",function(){
    let final=true;

    for(c of check){
        if(!c.checked){
            final=false;
         }
    } 
    checkAll.checked=final;
    });

//--------------------------
/*for(ch of check){
    ch.addEventListener("click",function(){

    let final=true;

    for(c of check){
        if(!c.checked){
            final=false;
         }
    } 
    checkAll.checked=final;
    })
};*/


//----------------------------
btn.addEventListener("click", function(){

    if(checkAll.checked==true){
         location.href="./join";
    }else{
        alert("약관 동의 해주세요");
    }
});