// $('#search_field')

$(document).ready(function() {
    console.log('ready');

    // Search by place name (blindly, without cleaning input)
    $('#search_button').click(function(e) {
        getSearchResults($('#search_field').val());
    })

    // Basic function to clear down the search field
    $('#clear_button').click(function(e) {
        $('#search_field').val('');
    })
});

function getSearchResults() {
    console.log('Getting search results');

    var searchTerm = $('#search_field').val();

    $.ajax('./api/thing/near/' + searchTerm, {
        success: function(data) {
            console.log('data: ', JSON.stringify(data));
        },
        error: function(err) {
            console.error('err: ', err);
        }
    })
}