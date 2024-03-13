var apiCalls = {
  init: function () {

    apiCalls.setup();
  },

  setup: function () {

    Window.apiEndPoints = {
      getCustomerPortfolio: apiCalls.getCustomerPortfolio,
      getProducts: apiCalls.getProducts,
      buyProduct: apiCalls.buyProduct
    }
  },

  getCustomerPortfolio: function (customerNum, success) {

    $.ajax({
      url: "http://localhost:8080/api/customer/" + customerNum,
      type: 'GET',
      dataType: 'json', // added data type
      success: success,
      error: function (jqXHR, textStatus, errorThrown) {
        console.log(textStatus);   // <-- printing error message to console
      }
    });
  },
  getProducts: function ( success) {

    $.ajax({
      url: "http://localhost:8080/api/productbucket",
      type: 'GET',
      dataType: 'json', // added data type
      success: success,
      error: function (jqXHR, textStatus, errorThrown) {
        console.log(textStatus);   // <-- printing error message to console
      }
    });
  },
  buyProduct: function (customerNum, data, success) {

    $.ajax({
      url: "http://localhost:8080/" + customerNum + "/buyPackage",
      type: 'POST',
      dataType: 'json', // added data type
      data: data,
      success: success,
      error: function (jqXHR, textStatus, errorThrown) {
        console.log(textStatus);   // <-- printing error message to console
      }
    });
  }
};

$(document).ready(apiCalls.init);