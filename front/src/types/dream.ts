import { User } from "./user";

export type Dream = {
    id: number;
    user: User;
    likes: number;
    title: string;
    details: string;
    dreamDate: string;
    postDate: string;
}

export type DreamPage = {
    content: Dream[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}