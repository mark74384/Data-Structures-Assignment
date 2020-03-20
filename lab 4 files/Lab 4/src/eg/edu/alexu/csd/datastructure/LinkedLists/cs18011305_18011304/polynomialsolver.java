package eg.edu.alexu.csd.datastructure.LinkedLists.cs18011305_18011304;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.pow;

public class PolynomialSolver extends SingleLinkedList implements IPolynomialSolver {

    ILinkedList A = new SingleLinkedList();
    ILinkedList B = new SingleLinkedList();
    ILinkedList C = new SingleLinkedList();
    ILinkedList result = new SingleLinkedList();

    public class PolyTerm {
        int coeff;
        int expo;
        public PolyTerm(int coeff, int expo) {
            this.coeff = coeff;
            this.expo = expo;
        }

    }

    @Override
    public void setPolynomial(char poly, int[][] terms) {
        Arrays.sort(terms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        getList(poly).clear();
        for (int i = 0; i < terms.length; i++) {
            PolyTerm temp = new PolyTerm(terms[i][0], terms[i][1]);
            getList(poly).add(temp);
        }
    }

    @Override
    public String print(char poly) {
        if (getList(poly).size() == 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < (getList(poly).size()); i++) {
            PolyTerm temp = (PolyTerm) getList(poly).get(i);
            if (temp.coeff == 0) {
                continue;
            }
            if (builder.toString().length() == 0) {
                if (temp.coeff != 1 || temp.expo == 0) {
                    builder.append(temp.coeff);
                }
            } else {
                if (temp.coeff == 1) {
                    if (temp.expo == 0) {
                        builder.append("+1");
                    } else {
                        builder.append("+");
                    }
                } else if (temp.coeff > 0) {
                    builder.append("+" + temp.coeff);
                } else {
                    builder.append(temp.coeff);
                }
            }
            if (temp.expo == 1) {
                builder.append("X");
            } else if (temp.expo != 0) {
                builder.append("X^" + temp.expo);
            }
        }
        return builder.toString();
    }

    @Override
    public void clearPolynomial(char poly) {
        getList(poly).clear();
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        float result = 0;
        for (int i = 0; i < getList(poly).size(); i++) {
            PolyTerm temp = (PolyTerm) getList(poly).get(i);
            result += temp.coeff * (pow(value , temp.expo));
        }
        return result;
    }

    @Override
    public int[][] add(char poly1, char poly2) {
        result.clear();
        int i = 0, j = 0;
        ILinkedList list1 = getList(poly1);
        ILinkedList list2 = getList(poly2);
        while (i < list1.size() && j < list2.size()) {
            PolyTerm first = (PolyTerm) list1.get(i);
            PolyTerm second = (PolyTerm) list2.get(j);
            PolyTerm res;
            if (first.expo > second.expo) {
                res = new PolyTerm(first.coeff, first.expo);
                i++;
            } else if (first.expo < second.expo) {
                res = new PolyTerm(second.coeff, second.expo);
                j++;
            } else {
                res = new PolyTerm(first.coeff + second.coeff, first.expo);
                i++;
                j++;
            }
            result.add(res);
        }
        if (j < list2.size()) {
            while (j < list2.size()) {
                PolyTerm res;
                PolyTerm second = (PolyTerm) list2.get(j);
                res = new PolyTerm(second.coeff, second.expo);
                result.add(res);
                j++;
            }
        } else {
            while (i < list1.size()) {
                PolyTerm res;
                PolyTerm first = (PolyTerm) list1.get(i);
                res = new PolyTerm(first.coeff, first.expo);
                result.add(res);
                i++;
            }
        }
        return listToArray(result);
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        result.clear();
        int i = 0, j = 0;
        ILinkedList list1 = getList(poly1);
        ILinkedList list2 = getList(poly2);
        while (i < list1.size() && j < list2.size()) {
            PolyTerm first = (PolyTerm) list1.get(i);
            PolyTerm second = (PolyTerm) list2.get(j);
            PolyTerm res;
            if (first.expo > second.expo) {
                res = new PolyTerm(first.coeff, first.expo);
                i++;
            } else if (first.expo < second.expo) {
                res = new PolyTerm(-second.coeff, second.expo);
                j++;
            } else {
                res = new PolyTerm(first.coeff - second.coeff, first.expo);
                i++;
                j++;
            }
            result.add(res);
        }
        if (j < list2.size()) {
            while (j < list2.size()) {
                PolyTerm res;
                PolyTerm second = (PolyTerm) list2.get(j);
                res = new PolyTerm(-second.coeff, second.expo);
                result.add(res);
                j++;
            }
        } else {
            while (i < list1.size()) {
                PolyTerm res;
                PolyTerm first = (PolyTerm) list1.get(i);
                res = new PolyTerm(first.coeff, first.expo);
                result.add(res);
                i++;
            }
        }
        return listToArray(result);
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {
        result.clear();
        ILinkedList list1 = getList(poly1);
        ILinkedList list2 = getList(poly2);
        int i = 0, j = 0;
        PolyTerm res;
        PolyTerm term1;
        PolyTerm term2;
        for (i = 0; i < list1.size(); i++) {
            for (j = 0; j < list2.size(); j++) {
                term1 = (PolyTerm) list1.get(i);
                term2 = (PolyTerm) list2.get(j);
                res = new PolyTerm(term1.coeff * term2.coeff, term1.expo + term2.expo);
                result.add(res);
            }
        }
        //simplification and sorting of result
        result = simplify(result);
        int[][] sortedResult = sort(result);
        setPolynomial('R', sortedResult);
        return sortedResult;
    }

    public ILinkedList getList(char poly) {
        switch (poly) {
            case 'A': return A;
            case 'B': return B;
            case 'C': return C;
            case 'R': return result;
            default: throw new RuntimeException("Error");
        }
    }

    public int[][] listToArray (ILinkedList list) {
        int[][] retArray = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            PolyTerm temp = (PolyTerm) list.get(i);
            retArray[i][0] = temp.coeff;
            retArray[i][1] = temp.expo;
        }
        return retArray;
    }

    public ILinkedList simplify (ILinkedList list) {
        ILinkedList simplifiedList = new SingleLinkedList();
        for (int i = 0; i < list.size(); i++) {
            PolyTerm res = (PolyTerm) list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                PolyTerm term2 = (PolyTerm) list.get(j);
                if (res.expo == term2.expo) {
                    res.coeff = res.coeff + term2.coeff;
                }
            }
            if (!containsExponent(simplifiedList, res.expo)) {
                simplifiedList.add(res);
            }
        }
        return simplifiedList;
    }

    private boolean containsExponent(ILinkedList list, int expo) {
        for (int i = 0; i < list.size(); i++) {
            if (((PolyTerm) list.get(i)).expo == expo) {
                return true;
            }
        }
        return false;
    }

    public int[][] sort (ILinkedList list) {
        int[][] sortedArray = listToArray(list);
        Arrays.sort(sortedArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        return sortedArray;
    }

}
