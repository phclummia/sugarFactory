var uiFunctions = {

  config: {},
  init: function () {

    uiFunctions.setup();
  },

  setup: function () {
    uiFunctions.config.api = Window.apiEndPoints;
    uiFunctions.getPortfolio();
  },

  getPortfolio: function (data) {

    uiFunctions.config.api.getCustomerPortfolio("dummyCustomerNum",
        function (data) {
          $('#dataTable').DataTable({
            data: data.portfolio,
            columns: [
              {data: 'stockCode', title: 'Stock Code'},
              {data: 'stockDescription', title: 'Stock Description'},
              {data: 'currentValue', title: 'Current Value'},
              {data: 'todayChange', title: 'Today Change'}]
          });
        });
  }
};

$(document).ready(uiFunctions.init);