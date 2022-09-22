export interface Gamestate {
    id: number;
    finished: boolean;
    winner: string;
    boardstate: string[][];
}