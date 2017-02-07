$(document).ready(function() {
    $('#listadetarefas').DataTable();
} );    

function controlar() {
	if (document.getElementById("idLista").value == "null") {
		window.location = "/novalista";
		window.alert("É preciso criar uma lista antes");
	}
}