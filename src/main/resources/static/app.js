var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/getbyid", {}, $("#id").val());
}

function save(animalForm) {
    stompClient.send("/app/save", {}, getFormData(animalForm));
}

function showGreeting(message) {
    var form = $("#" + message["@class"].replace(".", "").toLowerCase() + "-form");
    var element;
    $.each(message, function(name, value){
        element = form.find('[name="' + name + '"]');
        if (element.is(':checkbox')) {
            element.prop('checked', value);
        } else {
            element.val(value);
        }
    });
}

function getFormData(form){
    form.find(":checkbox").each(function() {
        this.value = this.checked;
    })
    var unindexed_array = form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return JSON.stringify(indexed_array);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#get-by-id" ).click(function() { sendName(); });
    $( "#save-dog" ).click(function() { save($("#dog-form")); });
    $( "#save-cat" ).click(function() { save($("#cat-form")); });

});

