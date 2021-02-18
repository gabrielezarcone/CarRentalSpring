// Chiamate AJAX -------------------------------------------------------------------------------------------------------------------------------
function xhrCall(method, url, params, onloadFunction){
    var xhr = new XMLHttpRequest();
    xhr.open(method,url);
    xhr.onload = onloadFunction;
    xhr.send(params);
}

function disabilita(username){
    var method = 'GET';
    var url = './ajax/disabilitaCustomer?username='+username;
    var onloadfunction = function () {
        location.reload();
    }
    xhrCall(method,url,null,onloadfunction);
}

function cambiaStatoPrenotazione(url){
    let method = 'GET';
    let onloadfunction = function () {
        location.reload();
    }
    xhrCall(method,url,null,onloadfunction);
}
function approvaPrenotazione(idPrenotazione){
    let url = './ajax/approva/'+idPrenotazione;
    cambiaStatoPrenotazione(url);
}
function rifiutaPrenotazione(idPrenotazione){
    let url = './ajax/rifiuta/'+idPrenotazione;
    cambiaStatoPrenotazione(url);
}
// --------------------------------------------------------------------------------------------------------------------------------------------


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

function cercaUtente(urlListaUtenti){
    event.preventDefault();
    let filtro = document.getElementById("filtroRicercaUtente").value;
    let testo = document.getElementById("testoRicercaUtente").value;
    let url = urlListaUtenti+"/cerca/"+filtro+"/"+testo
    location.replace(url)
}

function cercaStatoPrenotazione(urlListaPrenotazioni){
    event.preventDefault();
    let filtro = document.getElementById("filtroStatoPrenotazione");
    let testo = filtro.value;
    var url = urlListaPrenotazioni+"/cerca/prenotazione/stato/"+testo
    if (filtro.value==="tutti"){
        url = urlListaPrenotazioni
    }
    location.replace(url)
}

function eliminaPrenotazione(idPrenotazione){
    var confirmed = confirm("Sicuro di voler cancellare questa prenotazione?");
    if (confirmed){
        var method = 'GET';
        var url = './ajax/eliminaPrenotazione/'+idPrenotazione;
        var onloadfunction = function () {
            location.reload();
        }
        xhrCall(method,url,null,onloadfunction);
    }
}