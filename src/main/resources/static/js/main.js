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