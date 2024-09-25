import com.android.ddmlib.IDevice
import com.intellij.openapi.ui.SimpleToolWindowPanel
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

class RandomNumber : SimpleToolWindowPanel(true) {

    private lateinit var rootPanel: JPanel
    private lateinit var shuffleButton: JButton
    private lateinit var randomNumber: JLabel
    private var selectedIDevice: IDevice? = null

    init {
     setContent(rootPanel)

        shuffleButton.addActionListener {
            randomNumber.text = java.util.UUID.randomUUID().toString()
        }
    }
}
