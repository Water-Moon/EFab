package mcjty.efab;


import mcjty.efab.commands.CmdSaveDefaults;
import mcjty.efab.setup.ModSetup;
import mcjty.lib.base.ModBase;
import mcjty.lib.proxy.IProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = EFab.MODID, name = EFab.MODNAME,
        dependencies =
                "required-after:mcjtylib_ng@[" + EFab.MIN_MCJTYLIB_VER + ",);" +
                "after:forge@[" + EFab.MIN_FORGE11_VER + ",)",
        version = EFab.MODVERSION)
public class EFab implements ModBase {

    public static final String MODID = "efab";
    public static final String MODNAME = "EFab";
    public static final String MODVERSION = "0.2.0";
    public static final String MIN_MCJTYLIB_VER = "3.5.0";

    public static final String MIN_FORGE11_VER = "13.19.0.2176";

    @SidedProxy(clientSide = "mcjty.efab.setup.ClientProxy", serverSide = "mcjty.efab.setup.ServerProxy")
    public static IProxy proxy;
    public static ModSetup setup = new ModSetup();

    @Mod.Instance(MODID)
    public static EFab instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        setup.preInit(event);
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        setup.init(e);
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        setup.postInit(e);
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CmdSaveDefaults());
    }

    @Override
    public String getModId() {
        return MODID;
    }

    @Override
    public void openManual(EntityPlayer player, int bookindex, String page) {

    }
}
