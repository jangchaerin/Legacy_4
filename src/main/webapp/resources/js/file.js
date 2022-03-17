const fileResult = document.getElementById('fileResult');
const fileAdd = document.getElementById('fileAdd');

let count=0;
fileAdd.addEventListener('click', function(){

    count++;
    if(count > 5){
        alert("파일은 5개까지 등록 가능합니다.");
        return ;
    }

    let div = document.createElement('div');    //<div></div>

    let file = document.createElement("input"); //<input>
    file.setAttribute("type", "file");          //<input type="file">
    file.setAttribute("name","files");           //<input type="file" name="files">
    
    let btn = document.createElement("button");
    btn.setAttribute("type", "button");
    btn.innerHTML="DEL";
    
    div.append(file);
    div.append(btn);
    fileResult.append(div);

})
