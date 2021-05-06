/**
 * 01章中級課題
 */
case class Switch (var isOn: Boolean)

def toggle(switch: Switch): Switch = {
  if (switch.isOn) Switch(false) else Switch(true)
}
