package io.tunabytes.bytecode.editor;

import io.tunabytes.bytecode.introspect.MixinInfo;
import io.tunabytes.bytecode.introspect.MixinMethod;
import org.objectweb.asm.tree.*;

/**
 * A mixins editor for copying methods from the mixins class to the target class.
 */
public class MethodMergerEditor implements MixinsEditor {

    @Override public void edit(ClassNode classNode, MixinInfo info) {
        for (MixinMethod method : info.getMethods()) {
            if (method.isOverwrite()) continue;
            if (method.isAccessor()) continue;
            if (method.isInject()) continue;
            if (method.isMirror()) continue;
            if (method.getName().equals("<init>")) continue;
            if (info.isMixinInterface() && (method.getMethodNode().access & ACC_ABSTRACT) != 0) continue;
            MethodNode mn = method.getMethodNode();
            MethodNode underlying = new MethodNode(mn.access, mn.name, mn.desc, mn.signature, mn.exceptions.toArray(new String[0]));
            underlying.instructions = new InsnList();
            underlying.instructions.add(mn.instructions);
            for (AbstractInsnNode instruction : underlying.instructions) {
                remapInstruction(classNode, info, instruction);
            }
            classNode.methods.add(underlying);
        }
    }
}
