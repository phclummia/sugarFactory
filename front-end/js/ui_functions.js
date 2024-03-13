var uiFunctions = {

  config: {},
  init: function () {
    uiFunctions.config.api = Window.apiEndPoints;

  },
  initPortfolio: function () {
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
  },
  initProducts: function () {
    uiFunctions.getProducts();
  },
  getProducts: function (data) {

    uiFunctions.config.api.getProducts(
        function (data) {

          // Package #1
          $('#dataTableSafe').DataTable({
            data: data.packages[0].stocks,
            columns: [
              {data: 'stockCode', title: 'Stock Code'},
              {data: 'stockDescription', title: 'Stock Description'},
              {data: 'currentValue', title: 'Current Value'},
              {data: 'todayChange', title: 'Today Change'}]
          });

          // Package #2
          $('#dataTableModerate').DataTable({
            data: data.packages[1].stocks,
            columns: [
              {data: 'stockCode', title: 'Stock Code'},
              {data: 'stockDescription', title: 'Stock Description'},
              {data: 'currentValue', title: 'Current Value'},
              {data: 'todayChange', title: 'Today Change'}]
          });

          // Package #3
          $('#dataTableAggressive').DataTable({
            data: data.packages[2].stocks,
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