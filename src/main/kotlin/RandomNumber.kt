import com.android.ddmlib.AndroidDebugBridge
import com.android.ddmlib.IDevice
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.psi.search.GlobalSearchScope
import javax.swing.DefaultComboBoxModel
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JComboBox
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextField

class RandomNumber : SimpleToolWindowPanel(true) {

//    private lateinit var rootPanel: JPanel
//    private lateinit var shuffleButton: JButton
//    private lateinit var randomNumber: JLabel
//    private var selectedIDevice: IDevice? = null


    private lateinit var rootPanel: JPanel
    private lateinit var permissionPanel: JPanel
    private lateinit var networkPanel: JPanel
    private lateinit var developerPanel: JPanel
    private lateinit var devicesListComboBox: JComboBox<String>
    private lateinit var currentActivityButton: JButton
    private lateinit var currentFragmentButton: JButton
    private lateinit var clearAppDataButton: JButton
    private lateinit var clearAppDataAndRestartButton: JButton
    private lateinit var uninstallAppButton: JButton
    private lateinit var refresh: JButton
    private lateinit var refresh2: JButton
    private lateinit var refresh3: JButton
    private lateinit var refresh4: JButton
    private lateinit var permissionButton: JButton
    private lateinit var grantAllPermissionsButton: JButton
    private lateinit var revokeAllPermissionsButton: JButton
    private lateinit var restartAppButton: JButton
    private lateinit var restartAppWithDebuggerButton: JButton
    private lateinit var forceKillAppButton: JButton
    private lateinit var testProcessDeathButton: JButton
    private lateinit var activitiesBackStackButton: JButton
    private lateinit var currentAppBackStackButton: JButton
    private lateinit var adbWifi: JButton
    private lateinit var setting: JButton
    private lateinit var devices: List<IDevice>
    private lateinit var enableDisableDontKeepActivities: JCheckBox
    private lateinit var enableDisableShowTaps: JCheckBox
    private lateinit var enableDisableShowLayoutBounds: JCheckBox
    private lateinit var enableDisableDarkMode: JCheckBox
    private lateinit var windowAnimatorScaleComboBox: JComboBox<String>
    private lateinit var transitionAnimatorScaleComboBox: JComboBox<String>
    private lateinit var animatorDurationScaleComboBox: JComboBox<String>
    private lateinit var networkRateLimitComboBox: JComboBox<String>
    private lateinit var wifiToggle: JButton
    private lateinit var mobileDataToggle: JButton
    private lateinit var inputOnDeviceTextField: JTextField
    private lateinit var openDeepLinkTextField: JTextField
    private lateinit var inputOnDeviceButton: JButton
    private lateinit var openDeepLinkButton: JButton
    private lateinit var openDeveloperOptionsButton: JButton
    private lateinit var openAccountsButton: JButton
    private lateinit var openAppSettingsButton: JButton
    private lateinit var firebaseButton: JButton
    private lateinit var firebaseTextField: JTextField
    private var selectedIDevice: IDevice? = null

    private lateinit var adbController: AdbController

    class AdbController(private var debugBridge: AndroidDebugBridge?) {

        private var updateDeviceList: ((List<IDevice>) -> Unit)? = null

        fun connectedDevices(block: (devices: List<IDevice>) -> Unit) {
            updateDeviceList = block
            updateDeviceList?.invoke(debugBridge?.devices?.toList() ?: listOf())
        }

    }

    init {
//     setContent(rootPanel)
        setContent(JScrollPane(rootPanel))

        devicesListComboBox.addItemListener {
            selectedIDevice = devices[devicesListComboBox.selectedIndex]
        }

//        shuffleButton.addActionListener {
//            randomNumber.text = java.util.UUID.randomUUID().toString()
//        }
    }

    private fun updateDevicesList() {
        adbController.connectedDevices { devices ->
            this.devices = devices
            selectedIDevice = this.devices.getOrElse(devices.indexOf(selectedIDevice)) { this.devices.getOrNull(0) }

            devicesListComboBox.model = DefaultComboBoxModel(
                devices.map { device ->
                    device.name
                }.toTypedArray()
            )
        }
    }

    fun initPlugin(adbController: AdbController) {
        this.adbController = adbController

        updateDevicesList()
    }

    fun String.psiClassByNameFromProject(project: Project): PsiClass? {
//        return JavaPsiFacade.getInstance(project).findClass(this, GlobalSearchScope.allScope(project))
        return ""
    }
}
