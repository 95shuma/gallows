<#import "partials/header.ftlh" as main />

<@main.renderWith scripts=["https://code.jquery.com/jquery-3.3.1.slim.min.js","https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js","https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"] styles=["https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"]>

    <div class="mx-auto mt-3 w-50">
        <h4 class="text-center">Hi, ${person.name}</h4>
        <br>
        <#if admin??>
            <p><button class="btn btn-primary btn-block w-100" type="button" data-toggle="modal" data-target="#addUser">Add user</button></p>
            <p><button class="btn btn-primary btn-block w-100" type="button" data-toggle="modal" data-target="#exampleModal">Add word</button></p>
            <p><a class="btn btn-primary btn-block w-100" href="/admin/all-stat" role="button">See All statistic</a></p>
        </#if>
        <#if user??>
            <p><a class="btn btn-success btn-block w-100" href="/user/game" role="button">Play</a></p>
            <p><a class="btn btn-primary btn-block w-100" href="/user/stat" role="button">See statistic</a></p>
        </#if>
        <p><a class="btn btn-danger btn-block w-100" href="/logout" role="button">Quit</a></p>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-uppercase" id="exampleModalLabel">Create new word</h5>
                </div>
                <div class="modal-body">
                    <form id="form-comment" action="/admin/add-word" method="post">
                        <div class="form-group">
                            <#if _csrf??>
                                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                            </#if>
                            <label for="word">Word</label>
                            <input minlength="1" maxlength="20" name="word" type="text" class="form-control" id="word" aria-describedby="emailHelp" placeholder="Input word">
                            <label for="des">Description</label>
                            <input minlength="5" maxlength="200" name="description" type="text" class="form-control" id="des" aria-describedby="emailHelp" placeholder="Input description">
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addUser" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-uppercase">Create new user</h5>
                </div>
                <div class="modal-body">
                    <form id="form-comment" action="/admin/add-user" method="post">
                        <div class="form-group">
                            <#if _csrf??>
                                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                            </#if>
                            <label for="name">User name</label>
                            <input minlength="1" maxlength="20" name="name" type="text" class="form-control" id="name" placeholder="Name">
                            <label for="password">User password</label>
                            <input minlength="1" maxlength="20" name="password" type="text" class="form-control" id="password" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus')
        })
    </script>

</@main.renderWith>