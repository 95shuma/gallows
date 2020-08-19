<#import "partials/header.ftlh" as main />

<@main.renderWith scripts=["https://code.jquery.com/jquery-3.3.1.slim.min.js","https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js","https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"] styles=["https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"]>

    <div class="mx-auto mt-3 w-50">
        <h4 class="text-center">Description: ${game.word.description}</h4>
        <br>
        <#list word_let as let>
            <div class="border border-info" style="width: 50px; height: 50px; margin: 10px; display: inline-block">
                <h3 class="text-center">${let}</h3>
            </div>
        </#list>
        <br>
        <h4>Attempts: ${game.end_attempts}</h4>
        <br>
        <form action="/user/check-letter" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <input type="hidden" name="game_id" value="${game.id}">
            <div class="form-group">
                <div class="row">
                    <#list letters as letter>
                        <div class="col-2">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="letter" id="letter${letter?counter}" value="${letter}">
                                <label class="form-check-label" for="letter${letter?counter}">
                                    ${letter}
                                </label>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary mb-2 w-100">Ok</button>
        </form>
    </div>

</@main.renderWith>