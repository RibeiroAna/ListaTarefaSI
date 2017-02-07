var tarefasFeitas = 0;
var tarefasNFeitas = 0;


function addTarefa() {
	var texto = document.getElementById("textoTarefa").value;

	if(texto == "") {
		window.alert("Texto não pode ser vazio");
		return;
	}

	var item =  document.createElement("li");
	item.className = "list-group-item";
	item.innerText = texto;
	item.contenteditable ="true";

	item.appendChild(addLink(" Fazer","glyphicon glyphicon-thumbs-up", function () {fazerTarefa(this);}));
	var desfazer = addLink(" Desfazer","glyphicon glyphicon-thumbs-down", function () {desfazerTarefa(this);})
	desfazer.childNodes[0].className += " linkDisabled"
	item.appendChild(desfazer);
	item.appendChild(addLink(" Excluir","glyphicon glyphicon-trash", function () {excluirTarefa(this);}));

	document.getElementById("listaDeTarefas").appendChild(item);
	document.getElementById("textoTarefa").value = "";
	tarefasNFeitas ++;
	atualizarBarraTarefa();
}

function addTarefasIniciais() {
	for (i = 1; i < 4; i ++) {
		document.getElementById("textoTarefa").value = "Tarefa " + i;
		addTarefa();
	}
}

function addLink(texto, glyphicon, onClick) {
	var link = document.createElement("a");
	link.className = "col-xs-1";
	link.href = "#";
	var span = document.createElement("span");
	span.className = glyphicon;
	span.innerText = texto;
	span.onclick = onClick;
	link.appendChild(span);
	return link;
}

function excluirTarefa(tarefaButton) {
	var tarefa = 	tarefaButton.parentElement.parentElement;
  tarefa.className += " excluido";
	if (tarefa.className.includes("feito")) {
		tarefasFeitas--;
	}
	else {
		tarefasNFeitas--;
	}
	atualizarBarraTarefa();
}

function fazerTarefa(tarefa) {
	console.log(tarefa.parentElement.parentElement.childNodes[2].childNodes[0], tarefa);
	switchLinks(tarefa, tarefa.parentElement.parentElement.childNodes[2].childNodes[0]);
	console.log(tarefa.parentElement.parentElement.childNodes[2].childNodes[0], tarefa);
	tarefa.parentElement.parentElement.className += " feito";
	tarefasNFeitas --;
	tarefasFeitas ++;
	atualizarBarraTarefa();
}

function desfazerTarefa(tarefa) {
	switchLinks(tarefa, tarefa.parentElement.parentElement.childNodes[1].childNodes[0]);
	tarefa.parentElement.parentElement.className = "list-group-item";
	tarefasNFeitas ++;
	tarefasFeitas --;
	atualizarBarraTarefa();
}

function switchLinks(linkDisabled, linkEnabled) {
	linkDisabled.className += " linkDisabled";
	linkEnabled.className = linkEnabled.className.split(" ")[0] +" "+ linkEnabled.className.split(" ")[1];
}

function atualizarBarraTarefa() {
	var barraFeita = document.getElementById("barraFeita");
	var barraNFeita = document.getElementById("barraTotal");

	var prcFeita = (tarefasFeitas * 100) / (tarefasNFeitas + tarefasFeitas);
	barraFeita.innerText = "Tarefas Feitas: " + tarefasFeitas + " ("+ parseInt(prcFeita) + "%)";
	barraNFeita.innerText = "Tarefas Não Feitas: " +  tarefasNFeitas + " ("+ parseInt((100 - prcFeita)) + "%)";

	barraNFeita.style = "width: " + (100 - prcFeita) + "%";
	barraFeita.style = "width: " + prcFeita + "%";
}