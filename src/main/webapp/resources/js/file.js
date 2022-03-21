const fileResult = document.getElementById('fileResult');
const fileAdd = document.getElementById('fileAdd');
const del=document.getElementsByClassName("del");

let count=0;
let num=0;
fileAdd.addEventListener('click', function(){

  count++;//5가넘어가면 증가x
    if(count > 5){
        alert("파일은 5개까지 등록 가능합니다.");
        count=5;
        return ;
    }  
    
    

    let div = document.createElement('div');    //<div></div>
    div.setAttribute("id","del"+num);
   

    let file = document.createElement("input"); //<input>
    file.setAttribute("type", "file");          //<input type="file">
    file.setAttribute("name","files");           //<input type="file" name="files">
    
    let btn = document.createElement("button");
    btn.setAttribute("type", "button");
    btn.className="del"
    btn.setAttribute("data-num","del"+num)
    btn.innerHTML="DEL";
    
    div.append(file);
    div.append(btn);

    fileResult.append(div); 
    
    num++;

})

fileResult.addEventListener("click", function(event){

    let cn= event.target;

    if(cn.classList.contains('del')){
        let delNum=cn.getAttribute("data-num");
        document.getElementById(delNum).remove();
        count--;
    }
})
