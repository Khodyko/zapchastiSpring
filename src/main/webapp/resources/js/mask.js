document.addEventListener('DOMContentLoaded', () => {

  const elements = document.querySelectorAll('[data-mask="nn_mask"]') // ищем все поля с атрибутом data-mask="phone"
  if (!elements) return // если таких нет, прекращаем выполнение функции
  const phoneOptions = { // создаем объект параметров
    mask: '000_000_0' // задаем единственный параметр mask
  }
  elements.forEach(el => { // для каждого найденного поля с атрибутом [data-mask="phone"]
    IMask(el, phoneOptions) // инициализируем плагин с установленными выше параметрами
  })

})