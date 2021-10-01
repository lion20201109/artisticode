package org.artisticode.boot.utils.object;

import org.artisticode.boot.utils.collection.CollectionUtils;
import org.artisticode.boot.utils.map.MapUtils;
import org.artisticode.boot.utils.exception.ThrowNotStackException;
import org.artisticode.boot.utils.string.StringUtils;
import org.artisticode.boot.utils.validate.Validate;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
/**
 *
 Apache License
 Version 2.0, January 2004
 http://www.apache.org/licenses/

 TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION

 1. Definitions.

 "License" shall mean the terms and conditions for use, reproduction,
 and distribution as defined by Sections 1 through 9 of this document.

 "Licensor" shall mean the copyright owner or entity authorized by
 the copyright owner that is granting the License.

 "Legal Entity" shall mean the union of the acting entity and all
 other entities that control, are controlled by, or are under common
 control with that entity. For the purposes of this definition,
 "control" means (i) the power, direct or indirect, to cause the
 direction or management of such entity, whether by contract or
 otherwise, or (ii) ownership of fifty percent (50%) or more of the
 outstanding shares, or (iii) beneficial ownership of such entity.

 "You" (or "Your") shall mean an individual or Legal Entity
 exercising permissions granted by this License.

 "Source" form shall mean the preferred form for making modifications,
 including but not limited to software source code, documentation
 source, and configuration files.

 "Object" form shall mean any form resulting from mechanical
 transformation or translation of a Source form, including but
 not limited to compiled object code, generated documentation,
 and conversions to other media types.

 "Work" shall mean the work of authorship, whether in Source or
 Object form, made available under the License, as indicated by a
 copyright notice that is included in or attached to the work
 (an example is provided in the Appendix below).

 "Derivative Works" shall mean any work, whether in Source or Object
 form, that is based on (or derived from) the Work and for which the
 editorial revisions, annotations, elaborations, or other modifications
 represent, as a whole, an original work of authorship. For the purposes
 of this License, Derivative Works shall not include works that remain
 separable from, or merely link (or bind by name) to the interfaces of,
 the Work and Derivative Works thereof.

 "Contribution" shall mean any work of authorship, including
 the original version of the Work and any modifications or additions
 to that Work or Derivative Works thereof, that is intentionally
 submitted to Licensor for inclusion in the Work by the copyright owner
 or by an individual or Legal Entity authorized to submit on behalf of
 the copyright owner. For the purposes of this definition, "submitted"
 means any form of electronic, verbal, or written communication sent
 to the Licensor or its representatives, including but not limited to
 communication on electronic mailing lists, source code control systems,
 and issue tracking systems that are managed by, or on behalf of, the
 Licensor for the purpose of discussing and improving the Work, but
 excluding communication that is conspicuously marked or otherwise
 designated in writing by the copyright owner as "Not a Contribution."

 "Contributor" shall mean Licensor and any individual or Legal Entity
 on behalf of whom a Contribution has been received by Licensor and
 subsequently incorporated within the Work.

 2. Grant of Copyright License. Subject to the terms and conditions of
 this License, each Contributor hereby grants to You a perpetual,
 worldwide, non-exclusive, no-charge, royalty-free, irrevocable
 copyright license to reproduce, prepare Derivative Works of,
 publicly display, publicly perform, sublicense, and distribute the
 Work and such Derivative Works in Source or Object form.

 3. Grant of Patent License. Subject to the terms and conditions of
 this License, each Contributor hereby grants to You a perpetual,
 worldwide, non-exclusive, no-charge, royalty-free, irrevocable
 (except as stated in this section) patent license to make, have made,
 use, offer to sell, sell, import, and otherwise transfer the Work,
 where such license applies only to those patent claims licensable
 by such Contributor that are necessarily infringed by their
 Contribution(s) alone or by combination of their Contribution(s)
 with the Work to which such Contribution(s) was submitted. If You
 institute patent litigation against any entity (including a
 cross-claim or counterclaim in a lawsuit) alleging that the Work
 or a Contribution incorporated within the Work constitutes direct
 or contributory patent infringement, then any patent licenses
 granted to You under this License for that Work shall terminate
 as of the date such litigation is filed.

 4. Redistribution. You may reproduce and distribute copies of the
 Work or Derivative Works thereof in any medium, with or without
 modifications, and in Source or Object form, provided that You
 meet the following conditions:

 (a) You must give any other recipients of the Work or
 Derivative Works a copy of this License; and

 (b) You must cause any modified files to carry prominent notices
 stating that You changed the files; and

 (c) You must retain, in the Source form of any Derivative Works
 that You distribute, all copyright, patent, trademark, and
 attribution notices from the Source form of the Work,
 excluding those notices that do not pertain to any part of
 the Derivative Works; and

 (d) If the Work includes a "NOTICE" text file as part of its
 distribution, then any Derivative Works that You distribute must
 include a readable copy of the attribution notices contained
 within such NOTICE file, excluding those notices that do not
 pertain to any part of the Derivative Works, in at least one
 of the following places: within a NOTICE text file distributed
 as part of the Derivative Works; within the Source form or
 documentation, if provided along with the Derivative Works; or,
 within a display generated by the Derivative Works, if and
 wherever such third-party notices normally appear. The contents
 of the NOTICE file are for informational purposes only and
 do not modify the License. You may add Your own attribution
 notices within Derivative Works that You distribute, alongside
 or as an addendum to the NOTICE text from the Work, provided
 that such additional attribution notices cannot be construed
 as modifying the License.

 You may add Your own copyright statement to Your modifications and
 may provide additional or different license terms and conditions
 for use, reproduction, or distribution of Your modifications, or
 for any such Derivative Works as a whole, provided Your use,
 reproduction, and distribution of the Work otherwise complies with
 the conditions stated in this License.

 5. Submission of Contributions. Unless You explicitly state otherwise,
 any Contribution intentionally submitted for inclusion in the Work
 by You to the Licensor shall be under the terms and conditions of
 this License, without any additional terms or conditions.
 Notwithstanding the above, nothing herein shall supersede or modify
 the terms of any separate license agreement you may have executed
 with Licensor regarding such Contributions.

 6. Trademarks. This License does not grant permission to use the trade
 names, trademarks, service marks, or product names of the Licensor,
 except as required for reasonable and customary use in describing the
 origin of the Work and reproducing the content of the NOTICE file.

 7. Disclaimer of Warranty. Unless required by applicable law or
 agreed to in writing, Licensor provides the Work (and each
 Contributor provides its Contributions) on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 implied, including, without limitation, any warranties or conditions
 of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A
 PARTICULAR PURPOSE. You are solely responsible for determining the
 appropriateness of using or redistributing the Work and assume any
 risks associated with Your exercise of permissions under this License.

 8. Limitation of Liability. In no event and under no legal theory,
 whether in tort (including negligence), contract, or otherwise,
 unless required by applicable law (such as deliberate and grossly
 negligent acts) or agreed to in writing, shall any Contributor be
 liable to You for damages, including any direct, indirect, special,
 incidental, or consequential damages of any character arising as a
 result of this License or out of the use or inability to use the
 Work (including but not limited to damages for loss of goodwill,
 work stoppage, computer failure or malfunction, or any and all
 other commercial damages or losses), even if such Contributor
 has been advised of the possibility of such damages.

 9. Accepting Warranty or Additional Liability. While redistributing
 the Work or Derivative Works thereof, You may choose to offer,
 and charge a fee for, acceptance of support, warranty, indemnity,
 or other liability obligations and/or rights consistent with this
 License. However, in accepting such obligations, You may act only
 on Your own behalf and on Your sole responsibility, not on behalf
 of any other Contributor, and only if You agree to indemnify,
 defend, and hold each Contributor harmless for any liability
 incurred by, or claims asserted against, such Contributor by reason
 of your accepting any such warranty or additional liability.

 END OF TERMS AND CONDITIONS

 APPENDIX: How to apply the Apache License to your work.

 To apply the Apache License to your work, attach the following
 boilerplate notice, with the fields enclosed by brackets "[]"
 replaced with your own identifying information. (Don't include
 the brackets!)  The text should be enclosed in the appropriate
 comment syntax for the file format. We also recommend that a
 file or class name and description of purpose be included on the
 same "printed page" as the copyright notice for easier
 identification within third-party archives.

 Copyright [yyyy] [name of copyright owner]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
@EqualsAndHashCode
public class ObjectUtils {
    private static final char AT_SIGN = '@';
    public static final Null NULL = new Null();

    public ObjectUtils() {
    }

    /**
     * 任意一个为null 就返回true
     *
     * @param values object
     * @return boolean
     */
    public static boolean anyOneNullable(Object... values) {
        if (values == null) {
            return true;
        } else {
            for (Object var2 : values) {
                if (var2 == null) {
                    return true;
                }
                if ((var2 instanceof String && StringUtils.isBlank((String) var2))) {
                    return true;
                }
                if (var2 instanceof Collection && CollectionUtils.isEmpty((List<?>) var2)) {
                    return true;
                }
                if (var2 instanceof Map && MapUtils.isEmpty((Map<?, ?>) var2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof CharSequence) {
            return ((CharSequence)object).length() == 0;
        } else if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        } else if (object instanceof Collection) {
            return ((Collection<?>)object).isEmpty();
        } else {
            return object instanceof Map && ((Map<?,?>) object).isEmpty();
        }
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static <T> T defaultIfNull(T object, T defaultValue) {
        return object != null ? object : defaultValue;
    }

    @SafeVarargs
    public static <T> T firstNonNull(T... values) {
        if (values != null) {
            Object[] var1 = values;
            int var2 = values.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                T val = (T) var1[var3];
                if (val != null) {
                    return val;
                }
            }
        }

        return null;
    }

    public static boolean anyNotNull(Object... values) {
        return firstNonNull(values) != null;
    }

    public static boolean allNotNull(Object... values) {
        if (values == null) {
            return false;
        } else {
            Object[] var1 = values;
            int var2 = values.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Object val = var1[var3];
                if (val == null) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean notEqual(Object object1, Object object2) {
        return !object1.equals(object2);
    }

    public static String identityToString(Object object) {
        if (object == null) {
            return null;
        } else {
            String name = object.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(object));
            StringBuilder builder = new StringBuilder(name.length() + 1 + hexString.length());
            builder.append(name).append('@').append(hexString);
            return builder.toString();
        }
    }

    public static void identityToString(Appendable appendable, Object object) throws IOException {
        Validate.notNull(object, "Cannot get the toString of a null object", new Object[0]);
        appendable.append(object.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(object)));
    }



    public static void identityToString(StringBuffer buffer, Object object) {
        Validate.notNull(object, "Cannot get the toString of a null object", new Object[0]);
        String name = object.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(object));
        buffer.ensureCapacity(buffer.length() + name.length() + 1 + hexString.length());
        buffer.append(name).append('@').append(hexString);
    }

    public static void identityToString(StringBuilder builder, Object object) {
        Validate.notNull(object, "Cannot get the toString of a null object", new Object[0]);
        String name = object.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(object));
        builder.ensureCapacity(builder.length() + name.length() + 1 + hexString.length());
        builder.append(name).append('@').append(hexString);
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T... values) {
        T result = null;
        if (values != null) {
            Comparable[] var2 = values;
            int var3 = values.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                T value = (T) var2[var4];
                if (compare(value, result, true) < 0) {
                    result = value;
                }
            }
        }

        return result;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T... values) {
        T result = null;
        if (values != null) {
            Comparable[] var2 = values;
            int var3 = values.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                T value = (T) var2[var4];
                if (compare(value, result, false) > 0) {
                    result = value;
                }
            }
        }

        return result;
    }

    public static <T extends Comparable<? super T>> int compare(T c1, T c2) {
        return compare(c1, c2, false);
    }

    public static <T extends Comparable<? super T>> int compare(T c1, T c2, boolean nullGreater) {
        if (c1 == c2) {
            return 0;
        } else if (c1 == null) {
            return nullGreater ? 1 : -1;
        } else if (c2 == null) {
            return nullGreater ? -1 : 1;
        } else {
            return c1.compareTo(c2);
        }
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T... items) {
        Validate.notEmpty(items);
        Validate.noNullElements(items);
        TreeSet<T> sort = new TreeSet();
        Collections.addAll(sort, items);
        T result = (T) sort.toArray()[(sort.size() - 1) / 2];
        return result;
    }

    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T... items) {
        Validate.notEmpty(items, "null/empty items", new Object[0]);
        Validate.noNullElements(items);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet<T> sort = new TreeSet(comparator);
        Collections.addAll(sort, items);
        T result = (T) sort.toArray()[(sort.size() - 1) / 2];
        return result;
    }

    public static <T> T clone(T obj) {
        if (!(obj instanceof Cloneable)) {
            return null;
        } else {
            Object result;
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType.isPrimitive()) {
                    int length = Array.getLength(obj);
                    result = Array.newInstance(componentType, length);

                    while(length-- > 0) {
                        Array.set(result, length, Array.get(obj, length));
                    }
                } else {
                    result = ((Object[])obj).clone();
                }
            } else {
                try {
                    Method clone = obj.getClass().getMethod("clone");
                    result = clone.invoke(obj);
                } catch (NoSuchMethodException var4) {
                    throw new ThrowNotStackException.ThrowRuntimeException("Cloneable type " + obj.getClass().getName() + " has no clone " +
                            "method", var4);
                } catch (IllegalAccessException var5) {
                    throw new ThrowNotStackException.ThrowRuntimeException("Cannot clone Cloneable type " + obj.getClass().getName(), var5);
                } catch (InvocationTargetException var6) {
                    throw new ThrowNotStackException.ThrowRuntimeException("Exception cloning Cloneable type " + obj.getClass().getName(), var6.getCause());
                }
            }

            return (T) result;
        }
    }

    public static <T> T cloneIfPossible(T obj) {
        T clone = clone(obj);
        return clone == null ? obj : clone;
    }

    public static boolean CONST(boolean v) {
        return v;
    }

    public static byte CONST(byte v) {
        return v;
    }

    public static byte CONST_BYTE(int v) {
        if (v >= -128 && v <= 127) {
            return (byte)v;
        } else {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + v + "]");
        }
    }

    public static char CONST(char v) {
        return v;
    }

    public static short CONST(short v) {
        return v;
    }

    public static short CONST_SHORT(int v) {
        if (v >= -32768 && v <= 32767) {
            return (short)v;
        } else {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + v + "]");
        }
    }

    public static int CONST(int v) {
        return v;
    }

    public static long CONST(long v) {
        return v;
    }

    public static float CONST(float v) {
        return v;
    }

    public static double CONST(double v) {
        return v;
    }

    public static <T> T CONST(T v) {
        return v;
    }

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }
}
