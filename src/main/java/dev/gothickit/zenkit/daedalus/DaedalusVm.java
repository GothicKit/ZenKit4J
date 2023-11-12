package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DaedalusVm extends DaedalusScript {
	public DaedalusVm(@NotNull Read buf) {
		super(new Handle(ZenKit.API.ZkDaedalusVm_load(buf.getHandle()), ZenKit.API::ZkDaedalusVm_del));
		if (this.handle.isNull()) throw new RuntimeException("Failed to load DaedalusVm");
	}

	public DaedalusVm(String path) {
		super(new Handle(ZenKit.API.ZkDaedalusVm_loadPath(path), ZenKit.API::ZkDaedalusVm_del));
		if (this.handle.isNull()) throw new RuntimeException("Failed to load DaedalusVm");
	}

	public DaedalusVm(@NotNull Vfs vfs, String name) {
		super(new Handle(ZenKit.API.ZkDaedalusVm_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkDaedalusVm_del));
		if (this.handle.isNull()) throw new RuntimeException("Failed to load DaedalusVm");
	}

	public @Nullable DaedalusInstance getGlobalSelf() {
		return DaedalusInstance.fromNative(ZenKit.API.ZkDaedalusVm_getGlobalSelf(getHandle()));
	}

	public void setGlobalSelf(@Nullable DaedalusInstance value) {
		ZenKit.API.ZkDaedalusVm_setGlobalSelf(getHandle(), value == null ? null : value.getHandle());
	}

	public @Nullable DaedalusInstance getGlobalOther() {
		return DaedalusInstance.fromNative(ZenKit.API.ZkDaedalusVm_getGlobalOther(getHandle()));
	}

	public void setGlobalOther(@Nullable DaedalusInstance value) {
		ZenKit.API.ZkDaedalusVm_setGlobalOther(getHandle(), value == null ? null : value.getHandle());
	}

	public @Nullable DaedalusInstance getGlobalVictim() {
		return DaedalusInstance.fromNative(ZenKit.API.ZkDaedalusVm_getGlobalVictim(getHandle()));
	}

	public void setGlobalVictim(@Nullable DaedalusInstance value) {
		ZenKit.API.ZkDaedalusVm_setGlobalVictim(getHandle(), value == null ? null : value.getHandle());
	}

	public @Nullable DaedalusInstance getGlobalHero() {
		return DaedalusInstance.fromNative(ZenKit.API.ZkDaedalusVm_getGlobalHero(getHandle()));
	}

	public void setGlobalHero(@Nullable DaedalusInstance value) {
		ZenKit.API.ZkDaedalusVm_setGlobalHero(getHandle(), value == null ? null : value.getHandle());
	}

	public @Nullable DaedalusInstance getGlobalItem() {
		return DaedalusInstance.fromNative(ZenKit.API.ZkDaedalusVm_getGlobalItem(getHandle()));
	}

	public void setGlobalItem(@Nullable DaedalusInstance value) {
		ZenKit.API.ZkDaedalusVm_setGlobalItem(getHandle(), value == null ? null : value.getHandle());
	}

	public DaedalusInstance initInstance(String name, DaedalusInstanceType type) {
		var sym = getSymbolByName(name);
		if (sym == null || sym.getType() != DaedalusDataType.INSTANCE || !sym.isConst())
			throw new RuntimeException("Symbol not found");
		return initInstance(sym, type);
	}

	public DaedalusInstance initInstance(@NotNull DaedalusSymbol sym, DaedalusInstanceType type) {
		return DaedalusInstance.fromNative(ZenKit.API.ZkDaedalusVm_initInstance(getHandle(), sym.getHandle(), type));
	}

	public void call(String name) {
		var sym = getSymbolByName(name);
		if (sym == null || sym.getType() != DaedalusDataType.FUNCTION) throw new RuntimeException("Symbol not found");
		ZenKit.API.ZkDaedalusVm_callFunction(getHandle(), sym.getHandle());
	}

	public <TR> TR call(String name, Class<TR> rv) {
		var sym = getSymbolByName(name);
		if (sym == null || sym.getType() != DaedalusDataType.FUNCTION) throw new RuntimeException("Symbol not found");
		ZenKit.API.ZkDaedalusVm_callFunction(getHandle(), sym.getHandle());

		if (!sym.hasReturn()) throw new RuntimeException("The function does not return anything");
		return pop(rv);
	}

	public <TP0> void call(String name, TP0 p0) {
		push(p0);
		call(name);
	}

	public <TP0, TP1> void call(String name, TP0 p0, TP1 p1) {
		push(p0);
		push(p1);
		call(name);
	}

	public <TP0, TP1, TP2> void call(String name, TP0 p0, TP1 p1, TP2 p2) {
		push(p0);
		push(p1);
		push(p2);
		call(name);
	}

	public <TP0, TP1, TP2, TP3> void call(String name, TP0 p0, TP1 p1, TP2 p2, TP3 p3) {
		push(p0);
		push(p1);
		push(p2);
		push(p3);
		call(name);
	}

	public <TR, TP0> TR call(String name, TP0 p0, Class<TR> rv) {
		push(p0);
		return call(name, rv);
	}

	public <TR, TP0, TP1> TR call(String name, TP0 p0, TP1 p1, Class<TR> rv) {
		push(p0);
		push(p1);
		return call(name, rv);
	}

	public <TR, TP0, TP1, TP2> TR call(String name, TP0 p0, TP1 p1, TP2 p2, Class<TR> rv) {
		push(p0);
		push(p1);
		push(p2);
		return call(name, rv);
	}

	public <TR, TP0, TP1, TP2, TP3> TR call(String name, TP0 p0, TP1 p1, TP2 p2, TP3 p3, Class<TR> rv) {
		push(p0);
		push(p1);
		push(p2);
		push(p3);
		return call(name, rv);
	}

	public void registerExternal(String name, External0 cb) {
		registerExternalUnsafe(name, cb);
	}

	public <TP0> void registerExternal(String name, Class<TP0> cp0, External1<TP0> cb) {
		registerExternalUnsafe(name, () -> {
			var p0 = pop(cp0);
			cb.invoke(p0);
		});
	}

	public <TP0, TP1> void registerExternal(String name, Class<TP0> cp0, Class<TP1> cp1, External2<TP0, TP1> cb) {
		registerExternalUnsafe(name, () -> {
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			cb.invoke(p0, p1);
		});
	}

	public <TP0, TP1, TP2> void registerExternal(
			String name,
			Class<TP0> cp0,
			Class<TP1> cp1,
			Class<TP2> cp2,
			External3<TP0, TP1, TP2> cb
	) {
		registerExternalUnsafe(name, () -> {
			var p2 = pop(cp2);
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			cb.invoke(p0, p1, p2);
		});
	}

	public <TP0, TP1, TP2, TP3> void registerExternal(
			String name,
			Class<TP0> cp0,
			Class<TP1> cp1,
			Class<TP2> cp2,
			Class<TP3> cp3,
			External4<TP0, TP1, TP2, TP3> cb
	) {
		registerExternalUnsafe(name, () -> {
			var p3 = pop(cp3);
			var p2 = pop(cp2);
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			cb.invoke(p0, p1, p2, p3);
		});
	}


	public <TP0, TP1, TP2, TP3, TP4> void registerExternal(
			String name,
			Class<TP0> cp0,
			Class<TP1> cp1,
			Class<TP2> cp2,
			Class<TP3> cp3,
			Class<TP4> cp4,
			External5<TP0, TP1, TP2, TP3, TP4> cb
	) {
		registerExternalUnsafe(name, () -> {
			var p4 = pop(cp4);
			var p3 = pop(cp3);
			var p2 = pop(cp2);
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			cb.invoke(p0, p1, p2, p3, p4);
		});
	}

	public <TR> void registerExternal(String name, External0R<TR> cb) {
		registerExternalUnsafe(name, () -> push(cb.invoke()));
	}

	public <TR, TP0> void registerExternal(String name, Class<TP0> cp0, External1R<TR, TP0> cb) {
		registerExternalUnsafe(name, () -> {
			var p0 = pop(cp0);
			push(cb.invoke(p0));
		});
	}

	public <TR, TP0, TP1> void registerExternal(
			String name,
			Class<TP0> cp0,
			Class<TP1> cp1,
			External2R<TR, TP0, TP1> cb
	) {
		registerExternalUnsafe(name, () -> {
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			push(cb.invoke(p0, p1));
		});
	}

	public <TR, TP0, TP1, TP2> void registerExternal(
			String name,
			Class<TP0> cp0,
			Class<TP1> cp1,
			Class<TP2> cp2,
			External3R<TR, TP0, TP1, TP2> cb
	) {
		registerExternalUnsafe(name, () -> {
			var p2 = pop(cp2);
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			push(cb.invoke(p0, p1, p2));
		});
	}

	public <TR, TP0, TP1, TP2, TP3> void registerExternal(
			String name,
			Class<TP0> cp0,
			Class<TP1> cp1,
			Class<TP2> cp2,
			Class<TP3> cp3,
			External4R<TR, TP0, TP1, TP2, TP3> cb
	) {
		registerExternalUnsafe(name, () -> {
			var p3 = pop(cp3);
			var p2 = pop(cp2);
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			push(cb.invoke(p0, p1, p2, p3));
		});
	}


	public <TR, TP0, TP1, TP2, TP3, TP4> void registerExternal(
			String name,
			Class<TP0> cp0,
			Class<TP1> cp1,
			Class<TP2> cp2,
			Class<TP3> cp3,
			Class<TP4> cp4,
			External5R<TR, TP0, TP1, TP2, TP3, TP4> cb
	) {
		registerExternalUnsafe(name, () -> {
			var p4 = pop(cp4);
			var p3 = pop(cp3);
			var p2 = pop(cp2);
			var p1 = pop(cp1);
			var p0 = pop(cp0);
			push(cb.invoke(p0, p1, p2, p3, p4));
		});
	}


	public void printStackTrace() {
		ZenKit.API.ZkDaedalusVm_printStackTrace(getHandle());
	}

	public void registerExternalDefault(DefaultExternal cb) {
		ZenKit.API.ZkDaedalusVm_registerExternalDefault(
				getHandle(),
				(ctx, vm, sym) -> cb.invoke(this, new DaedalusSymbol(sym)),
				Pointer.NULL
		);
	}

	private <T> void push(@NotNull T value) {
		if (value instanceof Integer v)
			ZenKit.API.ZkDaedalusVm_pushInt(getHandle(), v);
		else if (value instanceof Float v)
			ZenKit.API.ZkDaedalusVm_pushFloat(getHandle(), v);
		else if (value instanceof String v)
			ZenKit.API.ZkDaedalusVm_pushString(getHandle(), v);
		else if (value instanceof DaedalusInstance v)
			ZenKit.API.ZkDaedalusVm_pushInstance(getHandle(), v.getHandle());
		else throw new UnsupportedOperationException("Invalid Daedalus type: " + value.getClass().getName());
	}

	private <T> T pop(Class<T> cls) {
		if (cls == Integer.class)
			return cls.cast(ZenKit.API.ZkDaedalusVm_popInt(getHandle()));
		if (cls == Float.class)
			return cls.cast(ZenKit.API.ZkDaedalusVm_popFloat(getHandle()));
		if (cls == String.class)
			return cls.cast(ZenKit.API.ZkDaedalusVm_popString(getHandle()));
		if (DaedalusInstance.class.isAssignableFrom(cls))
			return cls.cast(DaedalusInstance.fromNative(ZenKit.API.ZkDaedalusVm_popInstance(getHandle())));
		throw new UnsupportedOperationException("Invalid Daedalus type: " + cls.getName());
	}

	private void registerExternalUnsafe(String name, External0 cb) {
		var sym = getSymbolByName(name);
		if (sym == null || sym.getType() != DaedalusDataType.FUNCTION || !sym.isExternal())
			throw new RuntimeException("Symbol not found");
		ZenKit.API.ZkDaedalusVm_registerExternal(getHandle(), sym.getHandle(), (ctx, vm) -> cb.invoke(), Pointer.NULL);
	}

	public interface External0 {
		void invoke();
	}

	public interface External1<TP0> {
		void invoke(TP0 p0);
	}

	public interface External2<TP0, TP1> {
		void invoke(TP0 p0, TP1 p1);
	}

	public interface External3<TP0, TP1, TP2> {
		void invoke(TP0 p0, TP1 p1, TP2 p2);
	}

	public interface External4<TP0, TP1, TP2, TP3> {
		void invoke(TP0 p0, TP1 p1, TP2 p2, TP3 p3);
	}

	public interface External5<TP0, TP1, TP2, TP3, TP4> {
		void invoke(TP0 p0, TP1 p1, TP2 p2, TP3 p3, TP4 p4);
	}

	public interface External0R<TR> {
		TR invoke();
	}

	public interface External1R<TR, TP0> {
		TR invoke(TP0 p0);
	}

	public interface External2R<TR, TP0, TP1> {
		TR invoke(TP0 p0, TP1 p1);
	}

	public interface External3R<TR, TP0, TP1, TP2> {
		TR invoke(TP0 p0, TP1 p1, TP2 p2);
	}

	public interface External4R<TR, TP0, TP1, TP2, TP3> {
		TR invoke(TP0 p0, TP1 p1, TP2 p2, TP3 p3);
	}

	public interface External5R<TR, TP0, TP1, TP2, TP3, TP4> {
		TR invoke(TP0 p0, TP1 p1, TP2 p2, TP3 p3, TP4 p4);
	}


	public interface DefaultExternal {
		void invoke(DaedalusVm vm, DaedalusSymbol sym);
	}
}
