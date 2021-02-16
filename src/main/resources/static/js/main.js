function disabilita(username){
    var xhr = new XMLHttpRequest();
    var method = 'GET';
    var url = './ajax/disabilitaCustomer?username='+username;
    xhr.open(method,url);
    xhr.onload = function () {
        location.reload();
    }
    xhr.send();
}

// Se il campo viene modificato avviso il controller che dovrà criptare la password
// per farlo aggiungo una PathVariable opzionale
function modificaPassword(){
    var form = document.forms["user"];
    // rimuovo l'attributo GET dal link perchè non mi serve più
    let replaceRegx = /\?.*$/;
    form.action = form.action.replace(replaceRegx, "");
    // controllo che non sia già stato inserito /true per non inserirlo ogni volta che premo un tasto
    let checkRegx = /.*\/true$/;
    if (!checkRegx.test(form.action)){
        form.action += "/true";
    }
}