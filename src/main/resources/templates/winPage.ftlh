<#import "partials/header.ftlh" as main />

<@main.renderWith scripts=["https://code.jquery.com/jquery-3.3.1.slim.min.js","https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js","https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"] styles=["https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"]>

    <div class="mx-auto mt-3 w-50">

        <h3>You win!</h3>
        <br>
        <h4>Word: ${word}</h4>
        <br>
        <h4>Points: ${points}</h4>
    </div>

</@main.renderWith>